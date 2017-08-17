package com.example.uiactivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button buttonOK=(Button)findViewById(R.id.ok);
        buttonOK.setOnClickListener(buttonOnClickListener);
        
        Button buttonCancel=(Button)findViewById(R.id.cancel);
        buttonCancel.setOnClickListener(buttonOnClickListener);
    }

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
    	switch(keyCode){
    	case KeyEvent.KEYCODE_DPAD_CENTER:
    		Toast.makeText(this,"Center",Toast.LENGTH_SHORT).show();
    		break;
    	case KeyEvent.KEYCODE_DPAD_DOWN:
    		Toast.makeText(this,"Down",Toast.LENGTH_SHORT).show();
    		break;
    	case KeyEvent.KEYCODE_DPAD_UP:
    		Toast.makeText(this,"Up",Toast.LENGTH_SHORT).show();
    		break;
    	case KeyEvent.KEYCODE_DPAD_LEFT:
    		Toast.makeText(this,"Left",Toast.LENGTH_SHORT).show();
    		break;
    	case KeyEvent.KEYCODE_DPAD_RIGHT:
    		Toast.makeText(this,"Right",Toast.LENGTH_SHORT).show();
    		break;
    	default:
    		Toast.makeText(this, "The KeyEvent has been handled", Toast.LENGTH_SHORT).show();
    	}
		return true;
    }
    
    private OnClickListener buttonOnClickListener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			Toast.makeText(getBaseContext(), ((Button)v).getText().toString(), Toast.LENGTH_SHORT).show();
		}
    	
    };
}
