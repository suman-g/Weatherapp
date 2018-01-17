package com.example.weatherapp;

import android.database.sqlite.SQLiteDatabase;



public class CitiesTable {
    static final String TABLENAME="Cities";
    static final String COLUMN_id="id";
    static final String COLUMN_cityName="cityName";
    static final String COLUMN_country="country";
    static final String COLUMN_temperature="temperature";
    static final String COLUMN_favourite= "favourite";

    static public void onCreate(SQLiteDatabase db)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("CREATE TABLE "+TABLENAME+" (");
        sb.append(COLUMN_id+" integer primary key autoincrement, ");
        sb.append(COLUMN_cityName+" text not null, ");
        sb.append(COLUMN_country+" text not null, ");
        sb.append(COLUMN_temperature+" text not null, ");
        sb.append(COLUMN_favourite+" text not null);");

        try {
            db.execSQL(sb.toString());
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    static public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        CitiesTable.onCreate(db);
    }
}
