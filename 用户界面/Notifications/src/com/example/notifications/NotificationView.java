package com.example.notifications;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

public class NotificationView extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);
		
		//³·ÏúÍ¨Öª
		NotificationManager nm=(NotificationManager)
				getSystemService(Context.NOTIFICATION_SERVICE);
		nm.cancel(this.getIntent().getExtras().getInt("notivicationID"));
	}
}
