package com.example.dialogfragmentexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class DialogFragment1 extends DialogFragment {
	
	static DialogFragment1 newInstance(String title){
		DialogFragment1 dialogFragment1=new DialogFragment1();
		Bundle bundle=new Bundle();
		bundle.putString("title", title);
		dialogFragment1.setArguments(bundle);
		return dialogFragment1;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState){
		String stringTitle=this.getArguments().getString("title");
		AlertDialog.Builder builder=new AlertDialog.Builder(this.getActivity());
		builder.setIcon(R.drawable.ic_launcher);
		builder.setTitle(stringTitle);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getActivity(), "OK", Toast.LENGTH_SHORT).show();
			}
		});
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
			}
		});
		return builder.create();
	}
}
