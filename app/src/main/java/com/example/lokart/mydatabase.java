package com.example.lokart;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class mydatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="ProductDB";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_PRODUCTS="products";
    private static final String TITLE="name";
//    private static final
//    private static final
public mydatabase(@Nullable Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
}

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the table
        db.execSQL("CREATE TABLE " + TABLE_PRODUCTS + "(" + TITLE + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the table if it exists and create a new one
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    public void add(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TITLE, s);
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }
}
