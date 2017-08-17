package com.example.sqliteopenhelper;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	MyDatabaseHelper dbHelper;
	Button buttonInsert=null;
	Button buttonDisplay=null;
	
	final String SOURCE_DB_NAME="news";
	final String DEST_DB_NAME="MyDatabase.db3";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String destPath="data/data/"+this.getPackageName()+"/databases";
        File file=new File(destPath);
        if(file.exists()!=true){
        	file.mkdirs();
        	//Toast.makeText(this, "dirs "+destPath+" maken", Toast.LENGTH_LONG).show();
			try {
			   file.createNewFile();
				
				InputStream fis = this.getBaseContext().getAssets().open(SOURCE_DB_NAME);
				BufferedInputStream input=new BufferedInputStream(fis);
				
				FileOutputStream fos=new FileOutputStream(destPath+"/"+DEST_DB_NAME);
				BufferedOutputStream output=new BufferedOutputStream(fos);
				
				int readInt;
				while((readInt=input.read())!=-1){
					output.write((byte)readInt);
				}
				
				input.close();
				output.flush();
				output.close();
				Toast.makeText(this, "database copyed", Toast.LENGTH_LONG).show();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	
        }
        dbHelper=new MyDatabaseHelper(this,DEST_DB_NAME,1);
    }
    
    @Override
    public void onDestroy(){
    	super.onDestroy();
    	if(dbHelper!=null){
    		dbHelper.close();
    	}
    }
    
    public void onClickInsert(View view){
    	SQLiteDatabase db=dbHelper.getWritableDatabase();//利用SQLiteOpenHelper获得SQLiteDatabase
    	String sqlInsert="insert into news_inf values(null,?,?)";
    	String[] sqlValues={
    			((EditText)findViewById(R.id.editTextTitle)).getText().toString(),
    			((EditText)findViewById(R.id.editTextContent)).getText().toString(),
    	};
    	db.execSQL(sqlInsert,sqlValues);
    	Toast.makeText(this, "inserted", Toast.LENGTH_SHORT).show();
    }
    
    public void onClickDisplay(View view){
    	SQLiteDatabase db=dbHelper.getWritableDatabase();
    	String sqlQuery="select * from news_inf";
    	Cursor cursor=db.rawQuery(sqlQuery, null);
    	
    	String stringDisplay;
    	if(cursor.moveToFirst()==true){
    		do{
    			stringDisplay="id: "+cursor.getInt(0)+"\n"
        				+"news_title: "+cursor.getString(1)+"\n"
        				+"news_content: "+cursor.getString(2);
        		Toast.makeText(this,stringDisplay,Toast.LENGTH_SHORT).show();
    		}while(cursor.moveToNext()==true);
    	}
    }
}
