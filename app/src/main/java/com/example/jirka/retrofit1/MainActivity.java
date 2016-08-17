package com.example.jirka.retrofit1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.jirka.retrofit1.Adapters.GetWeatherRestAdapter;
import com.example.jirka.retrofit1.JSON.Weather;
import com.example.jirka.retrofit1.JSON.WeatherData;

import java.sql.Time;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOutput = (TextView) findViewById(R.id.tvOutput);

        TestWeatherData test = new TestWeatherData();
        test.runRetrofitTestAsync();
    }


    /**
     * Created by jirikrejci on 14.08.16.
     */
    public class TestWeatherData {
        GetWeatherRestAdapter mGetWeatherRestAdapter;

        //definice Callback
        Callback<WeatherData> mWeatherDataCallback = new Callback<WeatherData>() {
            String outputString = "";

            @Override
            public void success(WeatherData weatherData, Response response) {
                Log.d("JK", "Success: weatherData: base: " + weatherData.getName() +
                        " cod: " + weatherData.getCod()
                        + " coord-lon:" + weatherData.getCoord().getLon()
                        + " coord-lat: " + weatherData.getCoord().getLat()
                );
                Log.d("JK", "Coords to String:" + weatherData.getCoord().toString());
                outputString = weatherData.toString();
                Log.d("JK", "Whole to String: " + outputString);
                tvOutput.setText(outputString);

                List<Weather> weatherList = weatherData.getWeather();
                Weather weather = weatherList.get(0);

                Log.d ("JK", "Weather.main+description: "
                        + weatherData.getWeather().get(0).getMain()
                        + weatherData.getWeather().get(0).getDescription());

                Log.d ("JK Dates", "dt: " + (new Time(weatherData.getDt())).toString());
                Log.d ("JK Dates", "sunrise: " + (new Time(weatherData.getSys().getSunrise() * 1000L) ).toString());
                Log.d ("JK Dates", "sunset: " + (new Time(weatherData.getSys().getSunset() * 1000L)).toString());


            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("JK", "Failure: err:" + error);
            }
        };


        public void runRetrofitTestAsync() {
            if (mGetWeatherRestAdapter == null)
                mGetWeatherRestAdapter = new GetWeatherRestAdapter();
            mGetWeatherRestAdapter.testWeatherApiAsync("City od London, GB", "f51c090018cb53eaa363389cb68e5bdf", mWeatherDataCallback);
        }


    };




}
