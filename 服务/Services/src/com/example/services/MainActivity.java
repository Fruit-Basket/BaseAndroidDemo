package com.example.services;

import java.net.MalformedURLException;
import java.net.URL;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	Intent intent;
	MyService serviceBinder;
	
	private ServiceConnection connection=new ServiceConnection(){
		public void onServiceConnected(ComponentName className,IBinder service){
			serviceBinder=((MyService.MyBinder)service).getService();
			try{
				URL[] urls=new URL[]{
						new URL("http://www.baidu.com"),
						new URL("http://www.shaodafayuan.com"),
						new URL("http://www.hao123.com"),
						new URL("http://www.weibo.com")
				};
				serviceBinder.urls=urls;
			}
			catch(MalformedURLException e){
			}
			//intent已被设置为正确的值
			startService(intent);
		}
		
		
		public void onServiceDisconnected(ComponentName className){
			serviceBinder=null;
		}
	};
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    
    public void onClickStartService(View view){
    	Toast.makeText(getBaseContext(), "onClickStartService", Toast.LENGTH_SHORT).show();
    	//Intent intent=new Intent(getBaseContext(),MyService.class);
    	//Intent intent=new Intent(getBaseContext(),MyIntentService.class);
    	//startService(intent);
    	intent=new Intent(getBaseContext(),MyService.class);
    	this.bindService(intent,connection,Context.BIND_AUTO_CREATE);
    }
    
    
    public void onClickStopService(View view){
    	Intent intent=new Intent(this,MyService.class);
    	stopService(intent);
    }
}
