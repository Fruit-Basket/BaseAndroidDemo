package com.example.services;

import java.net.URL;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
	
	URL[] urls;
	private final IBinder binder=new MyBinder();

	@Override
	public IBinder onBind(Intent arg0) {
		return binder;
	}
	
	@Override
	public int onStartCommand(Intent intent,int flags,int startId){
		//Toast.makeText(this, "onStartCommand", Toast.LENGTH_SHORT).show();
		try{
			//int result=downloadFile(new URL("http://www.baidu.com"));
			//Toast.makeText(this, "result="+result, Toast.LENGTH_SHORT).show();
			//new DoBackgroundTask().execute(new URL("http://www.baidu.com"),new URL("http://www.shaodafayuan.com"));
			Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
			new DoBackgroundTask().execute(urls);
		}
		catch(Exception e){
			
		}
		return Service.START_STICKY;
	}
	
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
	}
	
	
	private int downloadFile(URL url){
		try{
			Thread.sleep(5000);
		}
		catch(InterruptedException ie){
			
		}
		return 100;
	}
	
	
	private class DoBackgroundTask extends AsyncTask<URL,Integer,Long>{

		@Override
		protected Long doInBackground(URL... urls) {
			int count=urls.length;
			long totalBytesDownload=0;
			int precent=0;
			for(int i=0;i<count;++i){
				totalBytesDownload+=downloadFile(urls[i]);
				precent=(int)(((i+1)/(float)count)*100);
				this.publishProgress(precent);
			}
			return totalBytesDownload;
		}
		
		
		@Override
		protected void onProgressUpdate(Integer... progress){
			Toast.makeText(getBaseContext(), String.valueOf(progress[0])+"% downloaded", Toast.LENGTH_SHORT).show();
		}
		
		
		@Override
	    protected void onPostExecute(Long result){
	    	Toast.makeText(getBaseContext(),String.valueOf(result),Toast.LENGTH_LONG).show();
	    	stopSelf();
	    }
	}
	
	
	public class MyBinder extends Binder{
		MyService getService(){
			return MyService.this;
		}
	}
}
