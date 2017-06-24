package com.example.dell.home1;
/*
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
public Database_Handler extends SQLiteOpenHelper {

	public Database_Handler(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	private static final String Register_Table = null;
	private String UserName_Column;
	private String Password;

	public boolean find(String user_name, String PassWord) throws SQLException {

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor get = db.rawQuery("select * from " + Register_Table + " where "
				+ UserName_Column + "=? and " + Password + "=?", new String[] {
				user_name, PassWord });

		if (get != null) {
			if (get.getCount() > 0) {
				return true;
			}
			db.close();
		}
		return false;

	}

}
*/