package com.example.jirka.retrofit1.JSON;

/**
 * Created by jirikrejci on 14.08.16.
 */


public class WeatherData_0 {
    private int cod;
    private String name;



    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    private String weatherMain;

    public WeatherData_0() {
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String base) {
        this.name = base;
    }
}
