package com.example.uicode;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        
        LayoutParams layoutParams=new LinearLayout.LayoutParams(
        		LayoutParams.MATCH_PARENT, 
        		LayoutParams.WRAP_CONTENT);
        
        LayoutParams layoutParams2=new LinearLayout.LayoutParams(
        		LayoutParams.MATCH_PARENT, 
        		LayoutParams.WRAP_CONTENT);
        
        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        
        TextView textView=new TextView(this);
        textView.setLayoutParams(layoutParams);
        textView.setText("hello world");
        
        Button button=new Button(this);
        button.setLayoutParams(layoutParams);
        button.setText("click me");
        
        linearLayout.addView(textView);
        linearLayout.addView(button);
        
        this.setContentView(linearLayout,layoutParams2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
