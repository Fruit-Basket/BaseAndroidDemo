package com.example.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle asvedInstanceState){
		return inflater.inflate(R.layout.fragment2,container,false);
		
	}
	
	@Override
	public void onStart(){
		super.onStart();
		Button btnGetText=(Button)this.getActivity().findViewById(R.id.btnGetText);

		btnGetText.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				TextView textView=(TextView)getActivity().findViewById(R.id.lblFragment1);
				Toast.makeText(getActivity(), textView.getText(), Toast.LENGTH_SHORT).show();
			}
			
		});
		
	}

}
