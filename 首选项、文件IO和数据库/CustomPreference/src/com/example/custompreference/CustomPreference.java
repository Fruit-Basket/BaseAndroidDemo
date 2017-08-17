package com.example.custompreference;

import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.view.Menu;
import android.view.MenuItem;

public class CustomPreference extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.addPreferencesFromResource(R.xml.custom_preference);
		
		Preference preference0=this.findPreference("preference0");
		preference0.setLayoutResource(R.layout.preference_default_layout);
		
		Preference preference1=this.findPreference("preference1");
		//preference1.setLayoutResource(R.layout.text_description_preference);
		preference1.setLayoutResource(R.layout.preference_layout);
	}
}
