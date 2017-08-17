package com.example.usingpreferences;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClickLoad(View view){
    	Intent intent=new Intent("com.example.usingpreferences.MyPreferenceActivity");
    	this.startActivity(intent);
    }
    
    public void onClickDisplay(View view){
    	SharedPreferences sharedPreference=this.getSharedPreferences(
    					"example1", 
    					this.MODE_PRIVATE);
    	Toast.makeText(this, 
    			sharedPreference.getString("editTextPref", ""),
    			Toast.LENGTH_SHORT)
    			.show();
    }
    
    public void onClickModify(View view){
    	SharedPreferences sharedPreference=this.getSharedPreferences(
				"example1", 
				this.MODE_PRIVATE);
    	SharedPreferences.Editor editor=sharedPreference.edit();
    	String editTextPrefValue=((EditText)findViewById(R.id.editText)).getText().toString();
    	editor.putString("editTextPref", editTextPrefValue);
    	editor.commit();
    	Toast.makeText(this, "Modify Completed", Toast.LENGTH_SHORT).show();
    }
}
