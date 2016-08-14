package com.example.jirka.retrofit1.Queries;

import com.example.jirka.retrofit1.JSON.WeatherData;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by jirikrejci on 14.08.16.
 */
public interface WeatherApi {
    @GET("/data/2.5/weather")
    void getWeatherFromApiAsync (
            @Query("q") String cityName,
            @Query("APPID") String apiKEY,
            Callback<WeatherData> callback
    );
    @GET ("data/2.5/weather")
    WeatherData getWeatherFromApiSync (
            @Query("q") String cityName
    );
}