package com.yopie.sunshine.model;

/**
 * Created by Yopie on 5/7/2017.
 */

public class DummyForecast {

    private String day;
    private String forecast;
    private int maxTemp;
    private int minTemp;
//    private int weatherId;


    public DummyForecast(String day, String forecast, int maxTemp, int minTemp) {
        this.day = day;
        this.forecast = forecast;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }
}
