package com.example.weatherapp;



public class Weather {
    String forecastdate;
    String avgiconurl;
    String temperature;
    String avgtemperature;
    String time;
    String weathericonurl;
    String condition;
    String pressure;
    String humidity;
    String windspeed;
    String winddirection;
    String cityname;
    String countrycode;
    String updateddate;

    @Override
    public String toString() {
        return "Weather{" +
                "forecastdate='" + forecastdate + '\'' +
                ", avgiconurl='" + avgiconurl + '\'' +
                ", temperature='" + temperature + '\'' +
                ", avgtemperature='" + avgtemperature + '\'' +
                ", time='" + time + '\'' +
                ", weathericonurl='" + weathericonurl + '\'' +
                ", condition='" + condition + '\'' +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                ", windspeed='" + windspeed + '\'' +
                ", winddirection='" + winddirection + '\'' +
                ", cityname='" + cityname + '\'' +
                ", countrycode='" + countrycode + '\'' +
                ", updateddate='" + updateddate + '\'' +
                '}';
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getForecastdate() {
        return forecastdate;
    }

    public void setForecastdate(String forecastdate) {
        this.forecastdate = forecastdate;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(String updateddate) {
        this.updateddate = updateddate;
    }

    public String getAvgiconurl() {
        return avgiconurl;
    }

    public void setAvgiconurl(String avgiconurl) {
        this.avgiconurl = avgiconurl;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getAvgtemperature() {
        return avgtemperature;
    }

    public void setAvgtemperature(String avgtemperature) {
        this.avgtemperature = avgtemperature;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeathericonurl() {
        return weathericonurl;
    }

    public void setWeathericonurl(String weathericonurl) {
        this.weathericonurl = weathericonurl;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }

    public String getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(String winddirection) {
        this.winddirection = winddirection;
    }
}
