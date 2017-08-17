package com.example.orientations;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str=(String)this.getLastNonConfigurationInstance();
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState){
    	outState.putString("ID", "11115012006");
    	super.onSaveInstanceState(outState);
    	//Toast.makeText(this, "onSaveInstanceState",Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
    	super.onRestoreInstanceState(savedInstanceState);
    	String ID=savedInstanceState.getString("ID");
    	Toast.makeText(this, ID, Toast.LENGTH_SHORT).show();
    	//Toast.makeText(this, "onRestoreInstanceState",Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public Object onRetainNonConfigurationInstance(){
    	return "Some text to preserver";
    }
}
