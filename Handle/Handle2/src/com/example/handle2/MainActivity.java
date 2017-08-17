package com.example.handle2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView textViewTimer;
	private TimerThread timerThread;
	private int counter=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textViewTimer=(TextView)this.findViewById(R.id.textViewTimer);
		textViewTimer.setText(String.valueOf(counter));
		
		timerThread=new TimerThread();
		timerThread.start();
	}
	
	public void startTimer(View view){
		timerThread.handler.sendEmptyMessage(0x123);
	}
	
	private class TimerThread extends Thread{
		protected Handler handler;
		
		@Override
		public void run(){
			Looper.prepare();//Ϊ���̴߳���Looper����
			handler=new Handler(){
				@Override
				public void handleMessage(Message message){
					if(message.what==0x123){
						//���ﲻ��ֱ���޸�ui����Ϊ����Ĵ��벻����UI�߳�
						//textViewTimer.setText(String.valueOf(counter));
						Toast.makeText(getBaseContext(), "in the thread", Toast.LENGTH_SHORT).show();
					}
				}
			};
			Looper.loop();
		}
	}
}
