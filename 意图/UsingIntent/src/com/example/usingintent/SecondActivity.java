package com.example.usingintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondactivity);
	}
	
	public void onClick(View source){
		Intent data=new Intent();
		EditText txt_username=(EditText)findViewById(R.id.txt_username);
		data.setData(Uri.parse(txt_username.getText().toString()));
		setResult(this.RESULT_OK,data);
		this.finish();
	}
}
