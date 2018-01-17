package com.example.weatherapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseOpenHelper extends SQLiteOpenHelper {
    static final String DB_Name="Cities.db";
    static final int DB_VERSION=17;

    public DatabaseOpenHelper(Context context) {
        super(context, DB_Name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CitiesTable.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        CitiesTable.onUpgrade(db,oldVersion,newVersion);
    }
}
