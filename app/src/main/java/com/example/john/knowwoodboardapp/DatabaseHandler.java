package com.example.john.knowwoodboardapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Delete * FROM "+TABLE_NAME);
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SCORE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, Integer score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3, score);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1) {
            return false;
        }else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + TABLE_NAME + " ORDER BY Score desc limit 10", null);
        return res;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[] {id});

    }
}
