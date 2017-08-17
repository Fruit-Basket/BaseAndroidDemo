package com.example.myactionbar;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ActionBar actionBar=this.getActionBar();
        //actionBar.hide();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        createMenu(menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
		return menuChoice(item);
    }
    
    private void createMenu(Menu menu){
    	MenuItem menuItem1=menu.add(0, 0, 0, "Item1");
    	menuItem1.setIcon(R.drawable.ic_launcher);
    	menuItem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
    	
    	MenuItem menuItem2=menu.add(0, 1, 1, "Item2");
    	menuItem2.setIcon(R.drawable.ic_launcher);
    	menuItem2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    	
    	MenuItem menuItem3=menu.add(0, 2, 2, "Item3");
    	menuItem3.setIcon(R.drawable.ic_launcher);
    	menuItem3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    	
    	MenuItem menuItem4=menu.add(0, 3, 3, "Item4");
    	menuItem4.setIcon(R.drawable.ic_launcher);
    	menuItem4.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    	
    	MenuItem menuItem5=menu.add(0, 4, 4, "Item5");
    	menuItem5.setIcon(R.drawable.ic_launcher);
    	menuItem5.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }
    
    private boolean menuChoice(MenuItem item){
    	switch(item.getItemId()){
    	case android.R.id.home:
    		Toast.makeText(this,"Application Icon",Toast.LENGTH_SHORT).show();
    		return true;
    	case 0:
    		Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show();
    		return true;
    	case 1:
    		Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
    		return true;
    	case 2:
    		Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show();
    		return true;
    	case 3:
    		Toast.makeText(this, "Item 4", Toast.LENGTH_SHORT).show();
    		return true;
    	case 4:
    		Toast.makeText(this, "Item 5", Toast.LENGTH_SHORT).show();
    		return true;
    	}
		return false;
    }
}
