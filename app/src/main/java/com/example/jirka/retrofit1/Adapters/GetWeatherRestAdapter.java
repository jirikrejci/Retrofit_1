package com.example.jirka.retrofit1.Adapters;

import com.example.jirka.retrofit1.JSON.WeatherData;
import com.example.jirka.retrofit1.Queries.WeatherApi;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by jirikrejci on 14.08.16.
 */
public class GetWeatherRestAdapter {
    protected final String TAG = getClass().getSimpleName();
    protected RestAdapter mRestAdapter;
    protected WeatherApi mApi;
    static final String WEATHER_URL = "http://api.openweathermap.org";

    public GetWeatherRestAdapter () {   // constructor
        mRestAdapter = new RestAdapter.Builder()        // vytvoření Adapter builderu
                .setLogLevel(RestAdapter.LogLevel.FULL) // nastavování configuration items
                .setEndpoint(WEATHER_URL)
                .build();   // bild adaptéru            // build
        mApi = mRestAdapter.create(WeatherApi.class);  // vytvoření API, abychom se k adaptéru dostali
    }

    // Deklarace API uvnitř adaptéru:

    public void testWeatherApiAsync (String city, String apiKey, Callback<WeatherData> cb) {
        //Asynchronous call. Pass result back via 'Callback - cb'
        mApi.getWeatherFromApiAsync(city, apiKey, cb);
    }

    public WeatherData testWeatherApiSync (String city) {
        // Synchronous call. Do not call in UI thread
        return mApi.getWeatherFromApiSync(city);
    }

}