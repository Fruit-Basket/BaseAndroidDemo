package com.example.timer;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

	private static int counter=0;
	private final int UPDATE_INTERVAL=1000;
	private Timer timer;
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent,int flags,int startId){
		super.onStartCommand(intent, startId, startId);
		counter=0;
		timer=new Timer();
		timer.scheduleAtFixedRate(new TimerTask(){

			@Override
			public void run() {
				Log.d("MyService",String.valueOf(counter++));
			}
			
		}, 0, UPDATE_INTERVAL);
		Toast.makeText(getBaseContext(), "start", Toast.LENGTH_SHORT).show();
		return Service.START_STICKY;
	}

	@Override
	public void onDestroy(){
		super.onDestroy();
		if(timer!=null){
			timer.cancel();
		}
		Toast.makeText(getBaseContext(), "stop", Toast.LENGTH_SHORT).show();
	}
}
