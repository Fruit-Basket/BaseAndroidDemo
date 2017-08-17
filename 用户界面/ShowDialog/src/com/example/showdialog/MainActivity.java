package com.example.showdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	
     private CharSequence[] items={"Google","Apple","Microsoft"};
     private  boolean[] checkedItems=new boolean[items.length];
     
     private ProgressDialog progressDialog;
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void onClick1(View source){
		showDialog(0);
	}
	
	public void onClick2(View source){
		showDialog(1);
	}
	
	public void onClick3(View source){
		showDialog(2);
		progressDialog.setProgress(0);
		new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<15;i++){
					try {
						Thread.sleep(1000);
						progressDialog.incrementProgressBy((int)100/15);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				progressDialog.dismiss();
			}
		}).start();
	}
	
	@Override
	protected Dialog onCreateDialog(int id){
		switch(id){
		case 0:
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setIcon(R.drawable.ic_launcher);
			builder.setTitle("This is a dialog with some simple text...");
			builder.setPositiveButton("OK", 
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getBaseContext(), "OK clicked!", Toast.LENGTH_SHORT).show();
						}
			        }
			);
			builder.setNegativeButton("Cancel", 
					new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getBaseContext(), "Cancel click!", Toast.LENGTH_SHORT).show();
							
						}
					}
			);
			builder.setMultiChoiceItems(items, checkedItems, 
					new DialogInterface.OnMultiChoiceClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which, boolean isChecked) {
							Toast.makeText(getBaseContext(), items[which]+(isChecked ? " clicked!" : " unclicked!"), Toast.LENGTH_SHORT).show();
							
						}
					}
			);
			return builder.create();
		case 1:
			final ProgressDialog dialog=ProgressDialog.show(this, "Do something...", "Please wait...",true);
			new Thread(new Runnable(){

				@Override
				public void run() {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					dialog.dismiss();
				}
				
			}).start();
			return dialog;
		case 2:
			progressDialog=new ProgressDialog(this);
			progressDialog.setTitle("Downloading files...");
			progressDialog.setIcon(R.drawable.ic_launcher);
			progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			
			progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getBaseContext(), "OK click!  "+getBaseContext().toString(), Toast.LENGTH_SHORT).show();
				}
			});
			progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getBaseContext(), "Cancel click!", Toast.LENGTH_SHORT);
				}
			});
			
			return progressDialog;
		}//end switch
		return null;
	}
	
}
