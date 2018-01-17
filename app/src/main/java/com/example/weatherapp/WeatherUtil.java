package com.example.weatherapp;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



public class WeatherUtil {

    public static class WeatherPullParser {

        public static ArrayList<Weather> parseWeather(InputStream input) throws XmlPullParserException, IOException {
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(input, "UTF-8");
            Weather weather = null;
            ArrayList<Weather> weatherArrayList = new ArrayList<>();
            int event = parser.getEventType();

            while(event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_TAG:
//                        if (parser.getName().equals("weatherdata")){
//                        }
//                        else if (parser.getName().equals("name")) {
//                            weather.setCityname(parser.nextText().trim());
//                        } else if (parser.getName().equals("country")) {
//                            weather.setCountrycode(parser.nextText().trim());
                      if (parser.getName().equals("time")) {
                            weather = new Weather();
                            String datetime = parser.getAttributeValue(null, "from");

                            weather.setForecastdate(datetime.split("T")[0]);
                            weather.setTime(datetime.split("T")[1]);
                        } else if (parser.getName().equals("windDirection")) {
                          String winddirection1 = parser.getAttributeValue(null, "deg");
                          String windcode  = parser.getAttributeValue(null, "code");
                          if(windcode.equals(null)){
                              windcode = "";
                          }
                          StringBuilder winddirection =  new StringBuilder();
                          winddirection.append(winddirection1);
                          winddirection.append("\u00b0");
                          winddirection.append(" ");
                          winddirection.append(windcode);
                          weather.setWinddirection(winddirection.toString());
                      }  else if (parser.getName().equals("windSpeed")) {
                          weather.setWindspeed(parser.getAttributeValue(null, "mps") + "mps,");
                      } else if (parser.getName().equals("temperature")) {
                            weather.setTemperature(parser.getAttributeValue(null, "value"));
                        } else if (parser.getName().equals("pressure")) {
                            weather.setPressure(parser.getAttributeValue(null, "value") + " " + parser.getAttributeValue(null, "unit"));
                        } else if (parser.getName().equals("humidity")) {
                            weather.setHumidity(parser.getAttributeValue(null, "value") + parser.getAttributeValue(null, "unit"));
                        } else if (parser.getName().equals("clouds")) {
                            weather.setCondition(parser.getAttributeValue(null, "value"));
                        }   else if (parser.getName().equals("symbol")) {
                            weather.setWeathericonurl("http://openweathermap.org/img/w/" + parser.getAttributeValue(null, "var") + ".png");
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("time")) {
                            weather.setAvgiconurl("");
                            weather.setAvgtemperature("");
                            weather.setUpdateddate("");
                            weather.setCountrycode("");
                            weather.setCityname("");
                            weatherArrayList.add(weather);
                        }
                        break;
                    default:
                        break;
                }
                event = parser.next();
            }
                    return weatherArrayList;
        }
    }
}
