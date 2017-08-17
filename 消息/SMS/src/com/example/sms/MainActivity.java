package com.example.sms;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	IntentFilter filter;
	
	private BroadcastReceiver receiver=new BroadcastReceiver(){

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			TextView textView=(TextView)findViewById(R.id.textView);
			textView.setText(arg1.getExtras().getString("sms"));
		}
		
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        filter=new IntentFilter();
    	filter.addAction("SMS_MESSAGE_RECEIVED");
    	this.registerReceiver(receiver, filter);
    }
    
    @Override
    protected void onResume(){
    	super.onResume();
    	//this.registerReceiver(receiver, filter);
    }
    
    @Override
    protected void onPause(){
    	super.onPause();
    	//this.unregisterReceiver(receiver);
    }
    
    @Override
    protected void onDestroy(){
    	super.onDestroy();
    	this.unregisterReceiver(receiver);
    }
     
    public void onClick(View veiw){
    	//SmsManager sms=SmsManager.getDefault();
    	//sms.sendTextMessage("5556", null, "hello zhouxuejin", null, null);
    	Intent intent=new Intent(android.content.Intent.ACTION_VIEW);
    	intent.setType("vnd.android-dir/mms-sms");
    	startActivity(intent);
    }
    
    
}
