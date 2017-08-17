package com.example.json;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;



import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView textView=null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView=(TextView)findViewById(R.id.textView);
        
        //String jsonString="[{'appeId':'1','inputTime':'4-26'},{'appeId':'2','inputTime':'4-27'}]";
        //new ReadJSONFeedTask().execute(jsonString);
        new ReadJSONFeedTask().execute("http://extjs.org.cn/extjs/examples/grid/survey.html");
        //new ReadJSONFeedTask().execute("http://www.baidu.com");
    }
    
    
    public String readJSONFeed(String urlString){
    	InputStream inputStream=null;
    	try{
    		inputStream=openHttpConnection(urlString);
    	}
    	catch(IOException ioe){
    		return "";
    	}
    	
    	StringBuilder stringBuilder=new StringBuilder();
    	try{
    		Scanner scanner=new Scanner(inputStream);
    		while(scanner.hasNext()==true){
    			stringBuilder.append(scanner.nextLine());
    		}
    	    inputStream.close();
    	}
    	catch(IOException ioe){
    		Toast.makeText(getBaseContext(), "Http Error !", Toast.LENGTH_SHORT).show();
    		return "";
    	}
		return stringBuilder.toString();
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

    
    private class ReadJSONFeedTask extends AsyncTask<String,Void,String>{
    	
    	protected String doInBackground(String...  urls){
    		//return urls[0];
			return readJSONFeed(urls[0]);
    	}
    	
    	@Override
    	protected void onPostExecute(String result){
    		JSONArray jsonArray;
    		JSONObject jsonObject=null;
    		String appeId=null;
    		String inputTime=null;
    		StringBuilder displayText=new StringBuilder();
    		try{
    			jsonArray=new JSONArray(result);
    			for(int i=0;i<jsonArray.length();++i){
    				jsonObject=jsonArray.getJSONObject(i);
    				appeId=jsonObject.getString("appeId");
    				inputTime=jsonObject.getString("inputTime");
    				displayText.append("appeId="+appeId+" , inputTime="+inputTime+"\n");
    			}
    		}
    		catch(Exception ioe){
    			Toast.makeText(getBaseContext(), "JSON parse error !", Toast.LENGTH_SHORT);
    		}
    		textView.setText(displayText);
    	}
    }
}
