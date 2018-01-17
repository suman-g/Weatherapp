package com.example.weatherapp;



public class SavedWeather {

    String cityname;
    String countryname;
    String date;
    String favorite;
    String temperature;


    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "SavedWeather{" +

                ", cityname='" + cityname + '\'' +
                ", countryname='" + countryname + '\'' +
                ", date='" + date + '\'' +
                ", favorite='" + favorite + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
