package com.example.passingdata;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        
        Toast.makeText(this, getIntent().getStringExtra("str1"), Toast.LENGTH_SHORT).show();
        
        Toast.makeText(this,Integer.toString(getIntent().getIntExtra("age1",0)),Toast.LENGTH_SHORT).show();
        
        Bundle bundle=getIntent().getExtras();
        
        Toast.makeText(this,bundle.getString("str2"),Toast.LENGTH_SHORT).show();
        
        Toast.makeText(this, Integer.toString(bundle.getInt("age2",0)), Toast.LENGTH_SHORT).show();
    } 
	
	public void onClick(View view){
		Intent i=new Intent("android.intent.action.MAIN");
		i.putExtra("age3", 32);
		i.setData(Uri.parse("Something to passed back to main activity"));
		this.setResult(this.RESULT_OK,i);
		this.finish();
		
	}

}
