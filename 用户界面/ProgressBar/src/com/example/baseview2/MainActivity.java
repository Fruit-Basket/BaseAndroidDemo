package com.example.baseview2;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	static int progress=0;
	ProgressBar progressBar;
	int progressStatus=0;
	Handler handler=new Handler();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        progress=0;
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(10);
        
        new Thread(new Runnable(){

			@Override
			public void run() {
				while(progressStatus<10){
					progressStatus=doSomeWork();
					handler.post(new Runnable(){
						@Override
						public void run() {
							progressBar.setProgress(progressStatus);
						}
					});
				}
			}

			private int doSomeWork() {
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				return ++progress;
			}
        	
        }).start();
    }
}
