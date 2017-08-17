package com.example.dialogfragmentexample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        DialogFragment1 dialogFragment1=DialogFragment1.newInstance("the title of the dialog fragment");
        dialogFragment1.show(this.getFragmentManager(), "dialog");
        
    }    
}
