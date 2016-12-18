package com.example.finalexamcpsu2016.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static  final String DATABASE_NAME = "login.db";
    private static  final int DATABASE_VERSION = 1;

    public static  final String TABLE_NAME = "login";
    public static  final String COL_ID = "_id";
    public static  final String COL_NAME = "name";
    public static  final String COL_USERNAME = "username";
    public static  final String COL_PASSWORD = "password";

    public static  final String SQL_CREATE_TABLE = "Create table " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NAME + " TEXT,"
            + COL_USERNAME + " TEXT,"
            + COL_PASSWORD + " TEXT"
            +")" ;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME,"Andriod Studio");
        cv.put(COL_USERNAME,"android");
        cv.put(COL_PASSWORD,"123456");
        db.insert(TABLE_NAME,null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
