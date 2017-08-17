package com.example.usingpreferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class MyPreferenceActivity extends PreferenceActivity {

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		this.addPreferencesFromResource(R.xml.preferences);
		PreferenceManager preferenceManager=this.getPreferenceManager();
		//preferenceManager.setSharedPreferencesName("preferences");
		preferenceManager.setSharedPreferencesName("example1");
		
	}
}
