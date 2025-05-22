package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes2.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String COLUMN_FLAG = "flag";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String DATABASE_NAME = "ctfApp.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "submissions";
    private SQLiteDatabase thisDB;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            this.thisDB = SQLiteDatabase.openDatabase(DATABASE_NAME, null, 1);
        } catch (Exception e) {
            throw new RuntimeException("[!] Error open DB file: ", e);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("DROP TABLE IF EXISTS submissions");
        onCreate(writableDatabase);
    }

    public boolean insertSubmission(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        contentValues.put(COLUMN_FLAG, str2);
        long insert = writableDatabase.insert(TABLE_NAME, null, contentValues);
        getAllSubmissions();
        return insert != -1;
    }

    public Cursor getAllSubmissions() {
        return getWritableDatabase().rawQuery("SELECT * FROM submissions", null);
    }
}
