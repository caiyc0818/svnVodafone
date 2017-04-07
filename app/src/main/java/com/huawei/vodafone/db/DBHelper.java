package com.huawei.vodafone.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private final static String DATABASE_NAME = "mydb.db";
	private final static int DATABASE_VERSION = 1;

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// 创建数据库
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table jokes (_id integer primary key autoincrement,idd text not null,type text not null,code text not null,content text not null)";
		db.execSQL(sql);
		db.execSQL("create table IF NOT EXISTS signin(id integer primary key autoincrement, title text,  time text, point integer,type integer,exchanged integer,reserved1 integer,reserved2 integer)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

}
