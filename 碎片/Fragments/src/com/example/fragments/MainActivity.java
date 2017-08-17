package com.example.fragments;

import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       /* FragmentManager fragmentManager=this.getFragmentManager();
        FragmentTransaction fragmentTransaction=
        		fragmentManager.beginTransaction();
        
        //get the current display information
        WindowManager wm=this.getWindowManager();
        Display d=wm.getDefaultDisplay();
        if(d.getWidth()>d.getHeight()){
        	Fragment1 fragment1=new Fragment1();
        	fragmentTransaction.replace(android.R.id.content, fragment1);
        	
        }
        else{
        	Fragment2 fragment2=new Fragment2();
        	fragmentTransaction.replace(android.R.id.content, fragment2);
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();*/
    }
    
}
