package com.example.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Bundle bundle=arg1.getExtras();
		SmsMessage[] smsMessages=null;
		String string="Sms from ";
		
		if(bundle!=null){
			Object[] pdus=(Object[])bundle.get("pdus");
			smsMessages=new SmsMessage[pdus.length];
			for(int i=0;i<smsMessages.length;i++){
				smsMessages[i]=SmsMessage.createFromPdu((byte[])pdus[i]);
				if(i==0){
					string+=smsMessages[i].getOriginatingAddress();
					string+=": ";
				}
				string+=smsMessages[i].getMessageBody().toString();
			}
			Toast.makeText(arg0, string, Toast.LENGTH_LONG).show();
			
			this.abortBroadcast();
			
			Intent intentMainActivity=new Intent(arg0,MainActivity.class);
			intentMainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    arg0.startActivity(intentMainActivity);
		    
			Intent intent=new Intent();
			intent.setAction("SMS_MESSAGE_RECEIVED");
			intent.putExtra("sms", string);
			arg0.sendBroadcast(intent);
		}
	}

}
