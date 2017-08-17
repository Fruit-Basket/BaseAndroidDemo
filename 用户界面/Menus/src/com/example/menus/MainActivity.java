package com.example.menus;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button=(Button)this.findViewById(R.id.button);
		button.setOnCreateContextMenuListener(this);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View view,ContextMenuInfo menuInfo){
		super.onCreateContextMenu(menu, view, menuInfo);
		this.createMenu(menu);
		
	}
	
	private void createMenu(Menu menu){
		MenuItem item1=menu.add(0,0,0,"item 1");
		item1.setIcon(R.drawable.ic_launcher);
	    
		MenuItem item2=menu.add(0,1,1,"item 2");
	}
}