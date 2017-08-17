package com.example.basicviews4;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	TimePicker timePicker;
	DatePicker datePicker;
	final int TIME_DIALOG_ID=0;
	final int DATE_DIALOG_ID=1;
	int hour;
	int minute;
	int year;
	int monthOfYear;
	int dayOfMonth;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //timePicker=(TimePicker)findViewById(R.id.timePicker);
        //timePicker.setIs24HourView(true);
        
        //datePicker=(DatePicker)findViewById(R.id.datePicker);
        
        //this.showDialog(TIME_DIALOG_ID);
        this.showDialog(DATE_DIALOG_ID);
    }
    
    @Override
    protected Dialog onCreateDialog(int id){
    	switch(id){
    	/*case TIME_DIALOG_ID:
    		return new TimePickerDialog(this,timeSetListener,hour,minute,false);*/
    	case DATE_DIALOG_ID:
    		return new DatePickerDialog(this,dateSetListener,year,monthOfYear,dayOfMonth);
    	}
		return null;
    }
    
    /*
    private TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener(){

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute){
			Toast.makeText(getBaseContext(), view.getCurrentHour()+":"+view.getCurrentMinute(), Toast.LENGTH_SHORT).show();
		}	
    	
    };*/
    
    private DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			Toast.makeText(getBaseContext(), year+"/"+monthOfYear+"/"+dayOfMonth, Toast.LENGTH_SHORT).show();
			
		}
	};
    
    /*public void onClick(View view){
    	String dateString="Date:"+datePicker.getYear()+"/"+datePicker.getMonth()+"/"+datePicker.getDayOfMonth();
    	//String timeString="Time:"+timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
    	//Toast.makeText(this,dateString+"\n"+timeString,Toast.LENGTH_SHORT).show();
    	Toast.makeText(this,dateString,Toast.LENGTH_SHORT).show();
    }*/
    
}
