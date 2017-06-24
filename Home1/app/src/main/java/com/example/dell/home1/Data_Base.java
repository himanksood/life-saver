package com.example.dell.home1;

    import android.content.Context;
    import android.database.sqlite.SQLiteOpenHelper;
    import java.util.ArrayList;
    import android.content.ContentValues;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mandeep kaur on 14-04-2015.
 */

    public class Data_Base extends SQLiteOpenHelper {
    public static final String dbname = "suri29";
    public static final Integer dbversion = 1;
    public static final String dbtable = "user";
    public static final String username = "username";
    public static final String column_id = "_id";
    public static final String password = "password";
    public static final String email_id = "email";
    public static final String contact_no = "contact_no";

    public Data_Base(Context context) {
        super(context, dbname, null, dbversion);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table " + dbtable + " (" + column_id
                + " integer primary key autoincrement, username text not null, password text not null,email text not null,contact_no not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVesion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("drop table if exists " + dbtable);
        onCreate(db);
    }

    public void oninsert(String use,String use1, String use3, String use4) {
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues c_values = new ContentValues();
        c_values.put("username", use);
        c_values.put("password", use1);
        c_values.put("email", use3);
        c_values.put("contact_no", use4);

        sql.insert(dbtable, null, c_values);
        sql.close();
    }

    public Cursor show() {

        String selectquery = "select * from " + dbtable;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectquery, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            cursor.moveToNext();
        }
        db.close();
        return cursor;
    }
    public int validate(String user, String pass) {

        String selectquery = "select * from " + dbtable +" where  "+username+"='"+user+"' and "+password+"='"+pass+"' ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectquery, null);
        return cursor.getCount();
    }
   /* public int validate1(String contac1) {

        String selectquery = "select * from " + dbtable +" where  "+contact_no+"='"+contac1+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectquery, null);
        return cursor.getCount();
    }*/
    public ArrayList<String> find(int id) {
        ArrayList<String> results = new ArrayList<String>();
        String query = "select * from " + dbtable + " where " + column_id + "="
                + id + "";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor get = db.rawQuery(query, null);

        get.moveToFirst();

        for (int i = 0; i < get.getCount(); i++) {

            results.add(get.getString(get.getColumnIndex(column_id)));
            results.add(get.getString(get.getColumnIndex("username")));

            get.moveToNext();
        }

        db.close();

        return results;
    }
}
