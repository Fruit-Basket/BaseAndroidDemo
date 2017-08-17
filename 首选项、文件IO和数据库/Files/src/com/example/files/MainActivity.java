package com.example.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button buttonSave,buttonLoad;
	private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSave=(Button)findViewById(R.id.buttonSave);
        buttonLoad=(Button)findViewById(R.id.buttonLoad);
        editText=(EditText)findViewById(R.id.editText);
    }
    
    @SuppressWarnings("deprecation")
	public void onClickSave(View view){
    	String string=editText.getText().toString();
    	try{
    		
    		/*FileOutputStream output=this.openFileOutput("textFile.txt", MODE_WORLD_READABLE);
    		OutputStreamWriter writer=new OutputStreamWriter(output);
    		writer.write(string);
    		writer.flush();
    		writer.close();*/
    		
    		//PrintWriter output=new PrintWriter(this.openFileOutput("textFile.txt", MODE_WORLD_READABLE));
    		
    		File sdCard=Environment.getExternalStorageDirectory();
    		File directory=new File(sdCard.getAbsolutePath()+"/MyFiles");
    		directory.mkdirs();
    		File file=new File(directory,"textFile.txt");
    		
    		/*FileOutputStream fileOutputStream=new FileOutputStream(file);
    		OutputStreamWriter output=new OutputStreamWriter(fileOutputStream);
    		output.write(string);
    		output.flush();
    		output.close();*/
    		
    		PrintWriter output=new PrintWriter(file);
    		output.print(string);
    		output.close();
    		
    		Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show();
    		//Toast.makeText(this, sdCard.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        	editText.setText("");
    	}
    	catch(IOException io3){
    		Toast.makeText(this, "Saved Fial", Toast.LENGTH_SHORT).show();
    	}
    	
    }
    
    public void onClickLoad(View view){
    	String string="";
    	try{
    		File sdCard=Environment.getExternalStorageDirectory();
    		File directory=new File(sdCard.getAbsolutePath()+"/MyFiles");
    		File file=new File(directory,"textFile.txt");
    		Scanner input=new Scanner(file);
    		while(input.hasNext()){
    			string+=input.nextLine();
    			if(input.hasNext()){
    				string+="\n";
    			}
    		}
    		input.close();
    		editText.setText(string);
    	    Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    	}catch(IOException ioe){
    		Toast.makeText(this, "Load Fial", Toast.LENGTH_SHORT).show();
    	}
    	
    }
}
