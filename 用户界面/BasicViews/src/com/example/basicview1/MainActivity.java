package com.example.basicview1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button buttonSave=(Button)findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(getBaseContext(),"Save",Toast.LENGTH_SHORT).show();	
			}
        });
        
        
        Button buttonOpen=(Button)findViewById(R.id.buttonOpen);
        buttonSave.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(getBaseContext(),"Open",Toast.LENGTH_SHORT).show();	
			}
        	
        });
        
        
        CheckBox checkBox=(CheckBox)findViewById(R.id.checkBoxAutoSave);
        checkBox.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				if(((CheckBox)v).isChecked()==true){
					Toast.makeText(getBaseContext(),"Checked",Toast.LENGTH_SHORT).show();	
				}
				else{
					Toast.makeText(getBaseContext(),"Unchecked",Toast.LENGTH_SHORT).show();	
				}
			}
        	
        });
        
        
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				RadioButton radioButton1=(RadioButton)findViewById(R.id.radioButton1);
				if(radioButton1.isChecked()==true){
					Toast.makeText(getBaseContext(),"1",Toast.LENGTH_SHORT).show();
				}
				else{
					Toast.makeText(getBaseContext(),"2",Toast.LENGTH_SHORT).show();
				}
			}
        });
    }

}
