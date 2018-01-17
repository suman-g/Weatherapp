package com.example.weatherapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.example.weatherapp.MainActivity.p1;

public class CityWeather extends AppCompatActivity implements GetData.WeatherData {
    String cityActivity2;
    String countryActivity2;
    String url;
    int p;
    DatabaseDataManager dm;
    ArrayList<AverageWeather> weathersArrayList;
    private RecycleAdapter adapter;
    private RecyclerView recyclerview;
    ArrayList<Weather> baseweatherlist;
    private RecycleAdapterBelow adapterbelow;
    private RecyclerView recyclerviewbelow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);
        dm = new DatabaseDataManager(this);
        cityActivity2 = getIntent().getExtras().getString("City").replaceAll(" ", "_");
        countryActivity2 = getIntent().getExtras().getString("Country").toUpperCase();
        url = "http://api.openweathermap.org/data/2.5/forecast?q=" + cityActivity2 + ","
                + countryActivity2 + "&mode=xml&appid=77b44f51476c02a87717c05aacc1f025";
        recyclerview = (RecyclerView) findViewById(R.id.MainRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerview.setLayoutManager(layoutManager);

        recyclerviewbelow = (RecyclerView) findViewById(R.id.recyler_view_2);
        LinearLayoutManager layoutManagerbelow = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerviewbelow.setLayoutManager(layoutManagerbelow);

        TextView DisplayTV = (TextView) findViewById(R.id.DisplayTV);
        DisplayTV.setText("Daily Forecast for " + cityActivity2 + ", " + countryActivity2);


        new GetData(this).execute(url);


    }

    @Override
    public void setupData(ArrayList<AverageWeather> applications) {
        weathersArrayList = new ArrayList<AverageWeather>();
        weathersArrayList = applications;


        adapter = new RecycleAdapter(CityWeather.this, weathersArrayList);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void setupBaseData(ArrayList<Weather> app) {
        baseweatherlist = new ArrayList<Weather>();
        baseweatherlist = app;
    }

    @Override
    public void calladapter(int position) {
        p = position;
        TextView textdate = (TextView) findViewById(R.id.textView_datethreehours);
        textdate.setText("Three Hourly Forecast on " + parseDateToddMMyyyy(weathersArrayList.get(position).getAvgdatenew()));
        String datecalled = weathersArrayList.get(position).getAvgdatenew();
        ArrayList<Weather> weatherdatelist = new ArrayList<Weather>();
        for (Weather w : baseweatherlist) {
            if (w.getForecastdate().equals(datecalled))
                weatherdatelist.add(w);
        }
        adapterbelow = new RecycleAdapterBelow(CityWeather.this, weatherdatelist);
        recyclerviewbelow.setAdapter(adapterbelow);
        adapterbelow.notifyDataSetChanged();
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void callmain(ArrayList<SavedWeather> s) {

    }

    @Override
    public MainActivity getactivity() {
        return null;
    }

    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "MMM, dd yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu2, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu2_settings: {

            }
            case R.id.menu2_savedcity: {
//                if((dm.getWeather(baseweatherlist.get(p).getCityname().replaceAll("_", " ")).getCityname().replaceAll("_", " ")).equals(baseweatherlist.get(p).getCityname().replaceAll("_", " "))) {
//                    SavedWeather weathersave = new SavedWeather();
//                    weathersave.setTemperature(String.valueOf(Math.round(Double.parseDouble(weathersArrayList.get(p).getAvgtempnew()) * 100) / 100D));
//                    weathersave.setCityname(baseweatherlist.get(p).getCityname());
//                    weathersave.setCountryname(baseweatherlist.get(p).getCountrycode());
//                    dm.update(weathersave);
//                    Toast.makeText(this,"City Updated",Toast.LENGTH_LONG).show();
//                } else {

                    SavedWeather weathersave = new SavedWeather();
                    weathersave.setTemperature(String.valueOf(Math.round(Double.parseDouble(weathersArrayList.get(p1).getAvgtempnew()) * 100) / 100D));
                    weathersave.setCityname(baseweatherlist.get(p1).getCityname().replaceAll("_", " "));
                    weathersave.setCountryname(baseweatherlist.get(p1).getCountrycode());
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    weathersave.setDate(String.valueOf((df.format(new Date()))));
                    weathersave.setFavorite("false");
                    long l = dm.save(weathersave);
                    Toast.makeText(this,"City Saved",Toast.LENGTH_LONG).show();
//                }
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}