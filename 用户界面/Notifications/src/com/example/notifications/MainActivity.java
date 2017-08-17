package com.example.notifications;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private int notificationID=1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view){
    	displayNotification();
    }
    
    public void displayNotification(){
    	Intent intent=new Intent(this,NotificationView.class);
    	intent.putExtra("notificationID",notificationID);
    	PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
    	
    	NotificationManager nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    	
    	Notification notification=new Notification(
    			R.drawable.ic_launcher,
    			"Reminder:Meeting starts in 5 minutes",
    			System.currentTimeMillis());
    	CharSequence from="System Alarm";
    	CharSequence message="Meeting with customer at 3pm...";
    	notification.setLatestEventInfo(this, from, message, pendingIntent);
    	notification.vibrate=new long[]{100,250,100,500};
    	
    	nm.notify(notificationID,notification);
    }
}
