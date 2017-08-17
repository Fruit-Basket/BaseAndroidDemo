package com.example.intents;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClickWebBrowser(View view){
    	Intent intent=new Intent(android.content.Intent.ACTION_VIEW,
    			Uri.parse("http://www.baidu.com"));
    	startActivity(intent);
    }
    
    public void onClickMakeCall(View view){
    	Intent intent =new Intent(android.content.Intent.ACTION_CALL,
    			Uri.parse("tel:+18211396396"));
    	startActivity(intent);
    }
    
    public void onClickLaunchMyBrowser(View view){
    	Intent intent=new Intent(android.content.Intent.ACTION_VIEW);
    	intent.setData(Uri.parse("http://99re.co"));
    	intent.addCategory("com.example.intents.MyBrowserActivity");
    	startActivity(Intent.createChooser(intent,"Open URL using..."));
    }
}
