package com.example.weatherapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;



public class CitiesDAO {
    private SQLiteDatabase db;

    public CitiesDAO(SQLiteDatabase db) {
        this.db = db;
    }
    public long save(SavedWeather weather ){
        ContentValues values = new ContentValues();
     //   values.put(CitiesTable.COLUMN_id,weather.());
        values.put(CitiesTable.COLUMN_cityName,weather.getCityname());
        values.put(CitiesTable.COLUMN_country,weather.getCountryname());
        values.put(CitiesTable.COLUMN_temperature,weather.getTemperature());
        values.put(CitiesTable.COLUMN_favourite,weather.getFavorite());

        return db.insert(CitiesTable.TABLENAME, null, values);
    }
    public boolean delete(SavedWeather weather){
        return db.delete(CitiesTable.TABLENAME, CitiesTable.COLUMN_cityName+"="+weather.getCityname(), null)>0;
    }
    public SavedWeather getWeather(String cityname){
        SavedWeather weather = null;
        Cursor c = db.query(true, CitiesTable.TABLENAME,
                new String[]{CitiesTable.COLUMN_id, CitiesTable.COLUMN_cityName, CitiesTable.COLUMN_country, CitiesTable.COLUMN_temperature, String.valueOf(CitiesTable.COLUMN_favourite)},
                CitiesTable.COLUMN_cityName+"="+cityname, null, null, null, null, null);
        if(c != null&&c.moveToFirst()){
            weather = this.buildNoteFromCursor(c);
        }
        if(!c.isClosed()){
            c.close();
        }
        return weather;
    }
    public List<SavedWeather> getAll(){
        List<SavedWeather> list = new ArrayList<SavedWeather>();
        Cursor c = db.query(CitiesTable.TABLENAME,
                new String[]{CitiesTable.COLUMN_id, CitiesTable.COLUMN_cityName, CitiesTable.COLUMN_country, CitiesTable.COLUMN_temperature, CitiesTable.COLUMN_favourite},
                null, null, null, null, null);
        if(c != null&&c.moveToFirst()){
            do{
                SavedWeather weather = this.buildNoteFromCursor(c);
                if(weather != null){
                    list.add(weather);
                }
            } while(c.moveToNext());
            if(!c.isClosed()){
                c.close();
            }
        }
        return list;
    }
    private SavedWeather buildNoteFromCursor(Cursor c){
        SavedWeather weather = null;
        if(c != null){
            weather = new SavedWeather();
          //  weather.set((int) c.getLong(0));
            weather.setCityname(c.getString(1));
            weather.setCountryname(c.getString(2));
            weather.setTemperature(c.getString(3));
            weather.setFavorite(c.getString(4));

        }
        return weather;
    }


    public boolean update(SavedWeather weather) {
        ContentValues values = new ContentValues();
        values.put(CitiesTable.COLUMN_cityName,weather.getCityname());
        values.put(CitiesTable.COLUMN_country,weather.getCountryname());
        values.put(CitiesTable.COLUMN_temperature,weather.getTemperature());
        values.put(CitiesTable.COLUMN_favourite,weather.getFavorite());
        return db.update(CitiesTable.TABLENAME, values, CitiesTable.COLUMN_cityName + "=" + weather.getCityname().replaceAll("_", " "), null)>0;

    }
}
