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
	 * 在调用getWritableDatabase()或getReadableDatabase()后，
	 * 如果数据库不存在时，自动调用本函数
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		//本例中，assset下的news数据已经创建了表。
		//db.execSQL(sqlCreateTable);
		System.out.println("SQLiteDatabase onCreate==========");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("SQLiteDatabase onUpgrade=============");
	}

}
