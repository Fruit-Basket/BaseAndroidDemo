package com.example.listfragmentexample;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class Fragment1 extends ListFragment {
	String[] presidents={
			"zhou",
			"xue",
			"jin",
			"zhu",
			"zhi",
			"ming"
		};
		
		@Override
		public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
	        		getActivity(),
	        		android.R.layout.simple_list_item_1,
	        		presidents);
	        this.setListAdapter(adapter);
	        
	    }
		
		@Override
		public View onCreateView(LayoutInflater inflater,
				ViewGroup container,Bundle savedInstanceState){
					return inflater.inflate(R.layout.fragment1,container,false);
		}
	    
}