package com.example.sound;

import java.io.IOException;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	MediaPlayer mp1;
	MediaPlayer mp2;
	MediaPlayer mp3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mp1=MediaPlayer.create(this, R.raw.s1);
		
		AssetManager am=this.getAssets();
		try{
			AssetFileDescriptor afd=am.openFd("s2.mp3");
			mp2=new MediaPlayer();
			mp2.setDataSource(afd.getFileDescriptor());
			mp2.prepare();
		}
		catch(Exception e){
			
		}
		
		mp3=new MediaPlayer();
		try {
			mp3.setDataSource(this,Uri.parse("http://www.zhlongyin.com/UploadFiles/xrxz/2011/5/201105051307513619.mp3"));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mp3.prepareAsync();
	}
	
	
	public void playRaw(View view){
		if(mp1!=null){
			mp1.start();
		}
	}
	
	
	public void playAssets(View view){
		if(mp2!=null){
			mp2.start();
		}
	}

	
	public void playUri(View view){
		if(mp3!=null){
			mp3.start();
		}
	}
}
