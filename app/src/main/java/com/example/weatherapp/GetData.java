package com.example.weatherapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class GetData extends AsyncTask<String, Void, ArrayList<Weather>> {
    ProgressDialog progress;
    CityWeather activity;

    public GetData(CityWeather activity) {
        this.activity = activity;
    }

    @Override
    protected void onPostExecute(ArrayList<Weather> weathers) {
        super.onPostExecute(weathers);
        progress.dismiss();
        if (weathers == null) {
            Toast.makeText(activity, "No cities match your search query", Toast.LENGTH_LONG).show();
            activity.finish();
        }
        else {


            HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

            for(Weather w : weathers) {
                String key = w.getForecastdate();
                if (hm.containsKey(key)) {
                    ArrayList<String> datetemperature = hm.get(key);
                    datetemperature.add(w.getTemperature());
                } else {
                    ArrayList<String> datetemperature = new ArrayList<String>();
                    datetemperature.add(w.getTemperature());
                    hm.put(key,datetemperature);
                }
            }
            Log.d("demo", hm.toString());
                HashMap<String, Double> newHM = new HashMap <String, Double>();
                for(Map.Entry<String, ArrayList<String>> entry : hm.entrySet()) {
                    String keypair = entry.getKey();
                    ArrayList<String> s = entry.getValue();
                    double sum = 0;
                    double avgtemp = 0;
                    for (int i = 0; i < s.size(); i++) {
                        sum = sum + Double.parseDouble(s.get(i));
                        avgtemp = sum / (double) s.size();
                    }
                    newHM.put(keypair,avgtemp);

                }
            Log.d("demo", newHM.toString());



            HashMap<String, ArrayList<String>> hm1 = new HashMap<String, ArrayList<String>>();
            for(Weather w : weathers) {
                String key = w.getForecastdate();
                if (hm1.containsKey(key)) {
                    ArrayList<String> dateiconurl = hm1.get(key);
                    dateiconurl.add(w.getWeathericonurl());
                } else {
                    ArrayList<String> dateiconurl = new ArrayList<String>();
                    dateiconurl.add(w.getWeathericonurl());
                    hm1.put(key,dateiconurl);
                }
            }

            HashMap<String, String> newHM1 = new HashMap <String, String>();
            for(Map.Entry<String, ArrayList<String>> entry : hm1.entrySet()) {
                String keypair1 = entry.getKey();
                ArrayList<String> s1 = entry.getValue();

                String median;
                if (s1.size() % 2 == 0) {
                    median = (s1.get(Math.round(s1.size() / 2)));
                }
                else {
                    median = (s1.get(s1.size() / 2));
                }
                newHM1.put(keypair1,median);

            }
            Log.d("demo", newHM1.toString());

        for(Weather w : weathers) {
            if (newHM.containsKey(w.getForecastdate())) {
                w.setAvgtemperature(String.valueOf(newHM.get(w.getForecastdate())));
            }
            if(newHM1.containsKey(w.getForecastdate())){
                w.setAvgiconurl(newHM1.get(w.getForecastdate()));
            }
            w.setCityname(activity.cityActivity2.replaceAll(" ", "_"));
            w.setCountrycode(activity.countryActivity2.toUpperCase());
        }
            ArrayList<AverageWeather> avgweatherlist = new ArrayList<>();

            for(Map.Entry<String, ArrayList<String>> entry : hm1.entrySet()) {
                String key = entry.getKey();
                AverageWeather w = new AverageWeather();
                w.setAvgdatenew(key);
                avgweatherlist.add(w);
            }

            for(AverageWeather w1 : avgweatherlist) {
                if (newHM.containsKey(w1.getAvgdatenew())) {
                    w1.setAvgtempnew(String.valueOf(newHM.get(w1.getAvgdatenew())));
                }
                if(newHM1.containsKey(w1.getAvgdatenew())){
                    w1.setAvgiconurlnew(newHM1.get(w1.getAvgdatenew()));
                }

            }
            Log.d("demo", weathers.toString());
            activity.setupBaseData(weathers);
            activity.setupData(avgweatherlist);
        }

        }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progress = new ProgressDialog(activity);
        progress.setMessage("Loading Data");
        progress.setIndeterminate(true);
        progress.setCancelable(false);
        progress.show();

    }

    @Override
    protected ArrayList<Weather> doInBackground(String... params) {

            try {

                URL url = new URL(params[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {

                    InputStream in = con.getInputStream();
                    return WeatherUtil.WeatherPullParser.parseWeather(in);

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

        return null;
    }

    static public interface WeatherData{
        public void setupData(ArrayList<AverageWeather> applications);
        public void setupBaseData(ArrayList<Weather> app);
        public void calladapter(int position);
        public Context getContext();
        public void callmain(ArrayList<SavedWeather> s);
        public MainActivity getactivity();
    }
}
