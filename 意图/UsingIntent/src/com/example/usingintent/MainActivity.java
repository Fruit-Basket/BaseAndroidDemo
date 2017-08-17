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
		
		//ʹ�ö�ӦActivity��action����ʼ��Intent
		myIntent=new Intent("net.learn2develop.SecondActivity");
		
		//��һ�ֳ�ʼ����������ʱĿ��Activity����ͱ�Activity����ͬһ����Ŀ��
		//myIntent=new Intent(this,Ŀ��Activity��.class);
		
		//this.startActivity(myIntent);
		
		this.startActivityForResult(myIntent, requestCode);
	}
	
	//һ������ۺ�ʱ���أ���Ҫ�����������
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
