package com.example.services;

import java.net.URL;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyIntentService extends IntentService {

	public MyIntentService() {
		super("MyIntentServiceName");
		//Toast.makeText(getBaseContext(), "Contruct", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		int  result=0;
		try{
			result=downloadFile(new URL("http://www.baidu.com"));
			Log.d("IntentService","onHandleIntent");
			Log.d("result",String.valueOf(result));
		}
		catch(Exception e){
			Log.d("Error","Error in download file");
		}
	}
	
	private int downloadFile(URL url){
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException ie){
			
		}
		return 100;
	}

}
