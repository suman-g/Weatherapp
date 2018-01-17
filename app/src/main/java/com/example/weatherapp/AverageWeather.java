package com.example.weatherapp;



public class AverageWeather {
    String avgtempnew;
    String avgiconurlnew;
    String avgdatenew;

    public String getAvgdatenew() {
        return avgdatenew;
    }

    public void setAvgdatenew(String avgdatenew) {
        this.avgdatenew = avgdatenew;
    }

    public String getAvgtempnew() {
        return avgtempnew;
    }

    public void setAvgtempnew(String avgtempnew) {
        this.avgtempnew = avgtempnew;
    }

    public String getAvgiconurlnew() {
        return avgiconurlnew;
    }

    public void setAvgiconurlnew(String avgiconurlnew) {
        this.avgiconurlnew = avgiconurlnew;
    }

    @Override
    public String toString() {
        return "AverageWeather{" +
                "avgtempnew='" + avgtempnew + '\'' +
                ", avgiconurlnew='" + avgiconurlnew + '\'' +
                ", avgdatenew='" + avgdatenew + '\'' +
                '}';
    }
}
