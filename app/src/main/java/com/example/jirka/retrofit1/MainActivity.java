package com.example.jirka.retrofit1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.view.SurfaceHolder;
import android.widget.TextView;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public interface GetWeatherApi {
        @GET ("/data/2.5/weather")
        void getWeatherFromApiAsync (
                @Query("q") String cityName,
                Callback <WeatherData> callback
        );
        @GET ("data/2.5/weather")
        WeatherData getWeatherFromApiSync (
                @Query("q") String cityName
        );
    }

    public class GetWeatherRestAdapter {
        protected final String TAG = getClass().getSimpleName();
        protected RestAdapter mRestAdapter;
        protected GetWeatherApi mApi;
        static final String WEATHER_URL = "http://api.openweathermap.org";

        public GetWeatherRestAdapter () {   // constructor
            mRestAdapter = new RestAdapter.Builder()        // vytvoření Adapter builderu
                    .setLogLevel(RestAdapter.LogLevel.FULL) // nastavování configuration items
                    .setEndpoint(WEATHER_URL)
                    .build();   // bild adaptéru            // build
            mApi = mRestAdapter.create(GetWeatherApi.class);  // vytvoření API, abychom se k adaptéru dostali
        }

        // Deklarace API uvnitř adaptéru:

        public void testWeatherApiAsync (String city, Callback<WeatherData> cb) {
            //Asynchronous call. Pass result back via 'Callback - cb'
            mApi.getWeatherFromApiAsync(city, cb);
        }

        public WeatherData testWeatherApiSync (String city) {
            // Synchronous call. Do not call in UI thread
            return mApi.getWeatherFromApiSync(city);
        }

    }


}
