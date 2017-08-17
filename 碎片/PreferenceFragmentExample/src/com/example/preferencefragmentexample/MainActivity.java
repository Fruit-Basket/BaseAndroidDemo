package com.example.preferencefragmentexample;

import com.example.preferancefragmentexample.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        FragmentManager fragmentManager=this.getFragmentManager();
        FragmentTransaction fragmentTransaction=
        		fragmentManager.beginTransaction(); 
        Fragment1 fragment1=new Fragment1();
        fragmentTransaction.replace(android.R.id.content, fragment1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    
}
