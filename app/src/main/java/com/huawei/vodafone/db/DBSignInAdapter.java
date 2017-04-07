package com.huawei.vodafone.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.huawei.vodafone.bean.SignInInfo;

public class DBSignInAdapter {
	final Context context;
	private DBHelper db;
	private SQLiteDatabase sq;
	private static final String ID = "id";
	private final static String DbTable = "signin";

	// type 1 签到 2购买历史 3 产品 4 当前points
	public DBSignInAdapter(Context context) {
		this.context = context;
		db = new DBHelper(context);
	}

	public DBSignInAdapter openDb() {
		sq = db.getWritableDatabase();
		return this;
	}

	public void closeDb() {
		db.close();
	}

	public long insert(String title, String time, int point, int type) {
		ContentValues values = new ContentValues();
		values.put("title", title);
		values.put("time", time);
		values.put("point", point);
		values.put("type", type);
		return sq.insert(DbTable, null, values);
	}

	public long insert(String title, String time, int point, int reserved1,
			int type) {
		ContentValues values = new ContentValues();
		values.put("title", title);
		values.put("time", time);
		values.put("point", point);
		values.put("type", type);
		values.put("reserved1", reserved1);
		return sq.insert(DbTable, null, values);
	}

	public boolean delete(String id) {
		String where = ID + " = ?";
		String whereArgs[] = { id };
		return sq.delete(DbTable, where, whereArgs) > 0;
	}

	public boolean delete() {
		return sq.delete(DbTable, null, null) > 0;
	}

	public void update(String title, String time, int point, int type,
			int reserved1) {
		ContentValues values = new ContentValues();
		values.put("title", title);
		values.put("time", time);
		values.put("point", point);
		values.put("type", type);
		sq.update(DbTable, values, "reserved1=?",
				new String[] { reserved1 + "" });
	}

	// private void updatePoints(int point) {
	// Cursor cursor = sq.query(true, DbTable, new String[] { "point" },
	// "type =" + 4, null, null, null, null, null);
	//
	// ContentValues values = new ContentValues();
	// values.put("title", item.getTitle());
	// values.put("time", item.getTime());
	// values.put("point", item.getPoint());
	// values.put("type", item.getType());
	// sq.update(DbTable, values, "id=?",
	// new String[] { String.valueOf(item.getId()) });
	// }

	// 查询一条记录
	public Cursor queryOneRecord(int id) throws SQLException {
		Cursor cursor = sq.query(true, DbTable, new String[] { "title", "time",
				"point", "type", "reserved1" }, "id =" + id, null, null, null,
				null, null);
		return cursor;
	}

	// 查询一条记录是否存在
	public boolean isRecordExisted(int id) {
		return queryOneRecord(id).moveToFirst();
	}

	// 查询所有记录
	public List<SignInInfo> queryAllRecord(int type) {
		int id;
		String title = null;
		String time = null;
		int point, reserved1 = 0;
		List<SignInInfo> list = null;
		Cursor cursor = sq.query(true, DbTable, new String[] { "id", "title",
				"time", "point", "reserved1" }, "type =\"" + type + "\"", null,
				null, null, "time", null);
		if (cursor != null) {
			list = new ArrayList<SignInInfo>();
			while (cursor.moveToNext()) {
				id = cursor.getInt(cursor.getColumnIndex("id"));
				title = cursor.getString(cursor.getColumnIndex("title"));
				time = cursor.getString(cursor.getColumnIndex("time"));
				point = cursor.getInt(cursor.getColumnIndex("point"));
				reserved1 = cursor.getInt(cursor.getColumnIndex("reserved1"));
				list.add(new SignInInfo(id, title, time, point, type, reserved1));
			}
		}
		return list;
	}
}
