package com.example.basicviews5;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	
	String[] presidents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView listView=this.getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);
        
        presidents=this.getResources().getStringArray(R.array.presidents_array);
        
        this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,presidents));
    }
    
    public void onClick(View view){
    	ListView listView=this.getListView();
    	String selectedItem="selected item: ";
    	for(int i=0;i<listView.getCount();i++){
    		if(listView.isItemChecked(i)){
    			selectedItem+=listView.getItemAtPosition(i)+"\n";
    		}
    	}
    	Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show();
    }
}
