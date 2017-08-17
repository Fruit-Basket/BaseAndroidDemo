package com.example.networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        new DownloadTextTask().execute("http://www.baidu.com");
    }
   
    
    private InputStream openHttpConnection(String urlString) throws IOException{
    	InputStream inputStream=null;
    	int response=-1;
    	
    	URL url=new URL(urlString);
        URLConnection urlConnection=url.openConnection();
        
        if((urlConnection instanceof HttpURLConnection)!=true){
        	throw new IOException("Not an Http connection");
        }
        else{
        	try{
        	HttpURLConnection http=(HttpURLConnection)urlConnection;
        	
        	http.setAllowUserInteraction(false);
        	http.setInstanceFollowRedirects(true);
        	http.setRequestMethod("GET");
        	
        	http.connect();
        	
        	response=http.getResponseCode();
        	if(response==HttpURLConnection.HTTP_OK){
        		inputStream=http.getInputStream();
        	}
        	}
        	catch(Exception ex){
        		throw new IOException("Error connecting");
        	}
        }
		return inputStream;
    }

    
    private String DownLoadText(String urlString){
    	InputStream inputStream=null;
    	try{
    		inputStream=openHttpConnection(urlString);
    	}
    	catch(IOException ioe){
    		return "";
    	}
    	
    	StringBuilder text=new StringBuilder();
    	try{
    		Scanner scanner=new Scanner(inputStream);
    		while(scanner.hasNext()==true){
    			text.append(scanner.nextLine()+'\n');
    		}
    	    inputStream.close();
    	}
    	catch(IOException ioe){
    		return "";
    	}
    	return text.toString();
    }
    
    
    private class DownloadTextTask extends AsyncTask<String,Void,String>{
    	
    	protected String doInBackground(String...  urls){
			return DownLoadText(urls[0]);
    	}
    	
    	@Override
    	protected void onPostExecute(String result){
    		Toast.makeText(getBaseContext(), result, Toast.LENGTH_SHORT).show();
    	}
    }
}
