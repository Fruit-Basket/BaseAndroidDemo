package com.example.video;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

	VideoView videoView;
	MediaController mc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		videoView=(VideoView)this.findViewById(R.id.videoView);
		
		Uri uri=Uri.parse("android.resource://com.example.video/res/raw/text.mp4");
		videoView.setVideoURI(uri);
				
	    mc=new MediaController(this);
		
	    mc.setMediaPlayer(videoView);
	    videoView.setMediaController(mc);
	    
	    
	}
}
