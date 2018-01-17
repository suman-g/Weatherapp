package com.example.weatherapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;


public class DatabaseDataManager {
    Context mContext;
    DatabaseOpenHelper  dbOpenHelper;
    SQLiteDatabase db;
    CitiesDAO citiesDao;

    public DatabaseDataManager(Context mContext){
        this.mContext = mContext;
        dbOpenHelper = new DatabaseOpenHelper(mContext);
        db = dbOpenHelper.getWritableDatabase();
        citiesDao = new CitiesDAO(db);
    }
    public void close(){
        db.close();
    }
    public long save(SavedWeather weather){

        return citiesDao.save(weather);
    }
    /*  public boolean updateNote(Note note){
          return noteDao.update(note);
      }*/
    public boolean delete(SavedWeather weather){
        return citiesDao.delete(weather);
    }
    public SavedWeather getWeather(String cityname){
        return citiesDao.getWeather(cityname);
    }
    public boolean update(SavedWeather weather){
        return citiesDao.update(weather);
    }
    public List<SavedWeather> getAll(){
        return citiesDao.getAll();
    }
}