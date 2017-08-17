package com.example.sqliteopenhelper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	/*final String sqlCreateTable="create table news_inf(" 
    		+"id integer primary key autoincrement,"
			+"news_title varchar(50),"
			+"news_content varchar(255))";*/
	
	public MyDatabaseHelper(Context context, String name, int version) {
		super(context, name, null, version);
	}

	/**
	 * �ڵ���getWritableDatabase()��getReadableDatabase()��
	 * ������ݿⲻ����ʱ���Զ����ñ�����
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		//�����У�assset�µ�news�����Ѿ������˱�
		//db.execSQL(sqlCreateTable);
		System.out.println("SQLiteDatabase onCreate==========");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("SQLiteDatabase onUpgrade=============");
	}

}
