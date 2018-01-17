package com.example.weatherapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GetData.WeatherData {
    Button search;
    EditText cityEditText;
    EditText countryEditText;
    TextView savedCities;
    TextView nosavedCities;
    String city;
    String country;
    public RecycleAdapterMainAct adapterMainAct;
    public RecyclerView recyclerviewmainact;
    DatabaseDataManager dm;
    ArrayList<SavedWeather> savedlist;
    Intent intent;
    static int p1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (Button) findViewById(R.id.button_search);

            recyclerviewmainact = (RecyclerView) findViewById(R.id.recyclerView_savedCities);
            LinearLayoutManager layoutManager3 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
            recyclerviewmainact.setLayoutManager(layoutManager3);
            adapterMainAct = new RecycleAdapterMainAct(MainActivity.this,savedlist);
            recyclerviewmainact.setAdapter(adapterMainAct);
            dm = new DatabaseDataManager(MainActivity.this);
            savedlist = (ArrayList<SavedWeather>) dm.getAll();
            adapterMainAct.notifyDataSetChanged();
        if (savedlist.size() > 0) {
            nosavedCities = (TextView) findViewById(R.id.textView_noSavedCities);
            nosavedCities.setVisibility(View.INVISIBLE);
        }

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cityEditText = (EditText) findViewById(R.id.editText_cityName);
                city = cityEditText.getText().toString();
                countryEditText = (EditText) findViewById(R.id.editText_CountryName);
                country = countryEditText.getText().toString();

                if(city.equals("")){
                    Toast.makeText(MainActivity.this, "Enter a city name", Toast.LENGTH_LONG).show();
                } else if(country.equals("")){
                    Toast.makeText(MainActivity.this, "Enter a country code", Toast.LENGTH_LONG).show();
                } else if(country.length() > 2) {
                    Toast.makeText(MainActivity.this, "Enter two letter country code", Toast.LENGTH_LONG).show();
                }
                else {

                    intent = new Intent(MainActivity.this, CityWeather.class);
                    intent.putExtra("City", city);
                    intent.putExtra("Country", country);
                    startActivity(intent);

                }
            }
        });


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Menu_Settings: {

            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setupData(ArrayList<AverageWeather> applications) {

    }

    @Override
    public void setupBaseData(ArrayList<Weather> app) {

    }

    @Override
    public void calladapter(int position) {
          p1 =  position;
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
        return MainActivity.this;
    }

    @Override
    protected void onResume() {
        super.onResume();


            recyclerviewmainact = (RecyclerView) findViewById(R.id.recyclerView_savedCities);
            LinearLayoutManager layoutManager3 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
            recyclerviewmainact.setLayoutManager(layoutManager3);
            adapterMainAct = new RecycleAdapterMainAct(MainActivity.this,savedlist);
            recyclerviewmainact.setAdapter(adapterMainAct);
             dm = new DatabaseDataManager(MainActivity.this);
             savedlist = (ArrayList<SavedWeather>) dm.getAll();
             adapterMainAct.notifyDataSetChanged();
        if (savedlist.size() > 0) {
            nosavedCities = (TextView) findViewById(R.id.textView_noSavedCities);
            nosavedCities.setVisibility(View.INVISIBLE);

        }
        }

    }

