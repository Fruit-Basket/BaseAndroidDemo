package com.example.basicviews6;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String[] presidents=this.getResources().getStringArray(R.array.presidents_array);      
        ArrayAdapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,presidents);
        
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
    }

}
