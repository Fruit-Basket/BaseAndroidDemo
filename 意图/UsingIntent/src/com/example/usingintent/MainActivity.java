package com.example.usingintent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	int requestCode=1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void onClickSecond(View source){
		Intent myIntent;
		
		//使用对应Activity的action名初始化Intent
		myIntent=new Intent("net.learn2develop.SecondActivity");
		
		//另一种初始化方法，此时目标Activity必须和本Activity处于同一个项目中
		//myIntent=new Intent(this,目标Activity名.class);
		
		//this.startActivity(myIntent);
		
		this.startActivityForResult(myIntent, requestCode);
	}
	
	//一个活动不论何时返回，都要调用这个方法
	public void onActivityResult(int requestCode,int resultCode,Intent data){
		if(requestCode==this.requestCode){
			if(resultCode==this.RESULT_OK){
				Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	public void onClickThird(View source){
		Intent myIntent;
		myIntent=new Intent("net.learn2develop.SecondActivity");
		this.startActivity(myIntent);
	}
}
