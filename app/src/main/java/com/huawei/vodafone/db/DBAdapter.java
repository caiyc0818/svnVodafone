package com.huawei.vodafone.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {
	final Context context;
	private DBHelper db;
	private SQLiteDatabase sq;
	public final static String FIELD_id = "_id";
	private static final String KEY_TYPE = "type";
	private static final String KEY_IDD = "idd";
	private static final String KEY_CONTENT = "content";
	private static final String KEY_CODE = "code";
	private final static String DbTable = "jokes";

	public DBAdapter(Context context) {
		this.context = context;
		db = new DBHelper(context);
	}

	public DBAdapter openDb() {
		sq = db.getWritableDatabase();
		return this;
	}

	public void closeDb() {
		db.close();
	}

	public long insert(String idd, String type, String code, String content) {
		ContentValues values = new ContentValues();
		values.put("idd", idd);
		values.put("type", type);
		values.put("code", code);
		values.put("content", content);
		return sq.insert(DbTable, null, values);
	}

	public boolean delete(String idd) {
		String where = KEY_IDD + " = ?";
		String whereArgs[] = { idd };
		return sq.delete(DbTable, where, whereArgs) > 0;
	}

	public boolean delete() {
		return sq.delete(DbTable, null, null) > 0;
	}

	public void update(String idd) {
		ContentValues values = new ContentValues();
		values.put("code", "1");
		sq.update(DbTable, values, "idd=?", new String[] { idd });
	}

	// 查询一条记录
	public Cursor queryOneRecord(String idd) throws SQLException {
		Cursor cursor = sq.query(true, DbTable, new String[] { FIELD_id,
				KEY_TYPE, KEY_CONTENT, KEY_CODE }, KEY_TYPE + "=" + "\"" + idd
				+ "\"", null, null, null, null, null);
		return cursor;
	}

	// 查询一条记录是否存在
	public boolean isRecordExisted(String hashId) {
		return queryOneRecord(hashId).moveToFirst();
	}

	// 查询所有记录
	public List<JokeMsg> queryAllRecord() {
		String idd = null;
		String type = null;
		String code = null;
		String content = null;
		List<JokeMsg> list = null;
		Cursor cursor = sq.query(DbTable, null, null, null, null, null, null);
		if (cursor != null) {
			list = new ArrayList<JokeMsg>();
			while (cursor.moveToNext()) {
				idd = cursor.getString(cursor.getColumnIndex(KEY_IDD));
				type = cursor.getString(cursor.getColumnIndex(KEY_TYPE));
				code = cursor.getString(cursor.getColumnIndex(KEY_CODE));
				content = cursor.getString(cursor.getColumnIndex(KEY_CONTENT));
				list.add(new JokeMsg(idd, type, code, content));
			}
		}
		return list;
	}
}
