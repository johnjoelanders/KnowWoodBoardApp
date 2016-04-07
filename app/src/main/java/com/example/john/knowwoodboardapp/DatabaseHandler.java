package com.example.john.knowwoodboardapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by John on 07/04/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper{
    public static final String DATABASE_NAME ="Knowwoodboard.db";
    public static final String TABLE_NAME ="highscores";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="Name";
    public static final String COL_3 ="Score";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SCORE INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
