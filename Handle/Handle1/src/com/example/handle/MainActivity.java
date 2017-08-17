package com.example.handle;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int counter=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView textViewTimer=(TextView)this.findViewById(R.id.textViewTimer);
		//textViewTimer.setText(counter);
		textViewTimer.setText(String.valueOf(counter));
		
		final Handler handler=new Handler(){
			@Override
			public void handleMessage(Message message){
				if(message.what==0x123){
					counter++;
					textViewTimer.setText(String.valueOf(counter));
				}
			}
		};
		
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<50;i++){
					try{
						Thread.sleep(1000);
					}
					catch(InterruptedException ie){
					}
					handler.sendEmptyMessage(0x123);
				}
			}
			
		}).start();
		
	}
}
