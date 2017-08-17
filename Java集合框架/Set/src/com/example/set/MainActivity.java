package com.example.set;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void buttonHashSet(View view){
		TestHashSet testHashSet=new TestHashSet();
		testHashSet.test();
		Toast.makeText(this, "test completed", Toast.LENGTH_SHORT).show();
	}
	
	public void buttonTreeSet(View view){
		(new TestTreeSet()).test();
		Toast.makeText(this, "test completed", Toast.LENGTH_SHORT).show();
	}
}
