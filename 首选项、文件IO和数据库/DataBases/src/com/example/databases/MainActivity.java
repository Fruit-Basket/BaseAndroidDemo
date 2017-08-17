package com.example.databases;

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

	SQLiteDatabase db;
	Button buttonInsert=null;
	Button buttonDisplay=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        db=SQLiteDatabase.openOrCreateDatabase(
        		this.getFilesDir().toString()+"/my.db3",
        		null);
        
        if(tableExist(db,"news_inf")==false){
        String sqlCreateTable="create table news_inf(" 
        		+"id integer primary key autoincrement,"
    			+"news_title varchar(50),"
    			+"news_content varchar(255))";
    	db.execSQL(sqlCreateTable);
        }
    }
    
    //判断数据库db中的表tableName是否存在
	private boolean tableExist(SQLiteDatabase db, String tableName){
		//这里没有判断db的合法性
		if(tableName==null){
			return false;
		}
		Cursor cursor = null;
		String sqlQuery="select count(*) from sqlite_master where type='table' and name='"+tableName+"'";
		cursor=db.rawQuery(sqlQuery,null);
		if(cursor.moveToFirst()==true){    //即使查询结果为空，仍然有cursor.moveToFirst()==true
			int count=cursor.getInt(0);
			if(count>0){
				return true;
			}
		}
		return false;
	}

	@Override
    public void onDestroy(){
    	super.onDestroy();
    	if(db!=null&&(db.isOpen()==true)){
    		db.close();
    	}
    }
    
    public void onClickInsert(View view){
    	String sqlInsert="insert into news_inf values(null,?,?)";
    	String[] sqlValues={
    			((EditText)findViewById(R.id.editTextTitle)).getText().toString(),
    			((EditText)findViewById(R.id.editTextContent)).getText().toString(),
    	};
    	db.execSQL(sqlInsert,sqlValues);
    	Toast.makeText(this, "inserted", Toast.LENGTH_SHORT).show();
    }
    
    public void onClickDisplay(View view){
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
