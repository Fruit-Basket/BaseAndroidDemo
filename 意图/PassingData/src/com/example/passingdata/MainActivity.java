package com.example.passingdata;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    } 
    
    public void onClick(View view){
    	//向被调用活动中传递数据
    	Intent i=new Intent("net.learn2develop.PassingDataSeconActivity");
    	i.putExtra("str1", "This is a string");
    	i.putExtra("age1",22);
    	
    	Bundle bundle=new Bundle();
    	bundle.putString("str2","This is another string");
    	bundle.putInt("age2", 23);
    	
    	i.putExtras(bundle);
    	
    	this.startActivityForResult(i, 1);
    	
    }
    
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
    	if(requestCode==1){
    		if(resultCode==this.RESULT_OK){
    			Toast.makeText(this, Integer.toString(data.getIntExtra("age3", 0)), Toast.LENGTH_SHORT).show();
    			
    			Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
    		}
    	}
    }
}
