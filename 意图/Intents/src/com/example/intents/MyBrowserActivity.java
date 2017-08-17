package com.example.intents;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyBrowserActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.browser);
		
	    String url=this.getIntent().getData().toString();
		
		WebView webView=(WebView)findViewById(R.id.webView);
		webView.setWebViewClient(new Callback());
		webView.loadUrl(url);
	}
	
	private class Callback extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view,String url){
			return (false);
		}
	}
}
