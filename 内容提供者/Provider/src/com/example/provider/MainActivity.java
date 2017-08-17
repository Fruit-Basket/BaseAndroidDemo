package com.example.provider;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.content.CursorLoader;
import android.database.Cursor;

public class MainActivity extends Activity {

    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Uri uriAllContacts=Uri.parse("content://contacts/people");
        Uri uriAllContacts=ContactsContract.Contacts.CONTENT_URI;
        Cursor cursor;
        CursorLoader cursorLoader=new CursorLoader(this,
        		uriAllContacts,
        		null,
        		null,
        		null,
        		null
        		);
        cursor=cursorLoader.loadInBackground();/**/
        Toast.makeText(this,"cursor loaded", Toast.LENGTH_SHORT).show();
        
        String contactName;
        String contactID;
        String phone;
        if(cursor.moveToFirst()==true){
        	do{
        		contactName=cursor.getString(
        				cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
        				);
        		contactID=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
        		Toast.makeText(this, contactName+" , "+contactID, Toast.LENGTH_SHORT).show();
        		
        		int hasPhone=cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
        		if(hasPhone==1){
        			Cursor cursorPhone;
        			Uri uriPhone=Uri.parse("content://contacts/people/"+contactID);
        			CursorLoader phoneCursorLoader=new CursorLoader(this,uriPhone,null,null,null,null);
        			cursorPhone=phoneCursorLoader.loadInBackground();
        			/*while(cursorPhone.moveToNext()==true){
        				phone=cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        				Toast.makeText(this, phone, Toast.LENGTH_SHORT).show();
        			}*/
        			if(cursorPhone.moveToFirst()==true){
        				do{
        					//phone=cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        					//phone=cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            				Toast.makeText(this, "phone", Toast.LENGTH_SHORT).show();
        				}while(cursorPhone.moveToNext());
        			}
        			cursorPhone.close();
        		}
        	}while(cursor.moveToNext()==true);
        }
    }
}
