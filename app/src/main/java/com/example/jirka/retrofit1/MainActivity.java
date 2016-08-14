package com.example.jirka.retrofit1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.jirka.retrofit1.Adapters.GetWeatherRestAdapter;
import com.example.jirka.retrofit1.JSON.WeatherData;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestWeatherData test = new TestWeatherData();
        test.runRetrofitTestAsync();
    }


    /**
     * Created by jirikrejci on 14.08.16.
     */
    public class TestWeatherData {
        GetWeatherRestAdapter mGetWeatherRestAdapter;
        Callback<WeatherData> mWeatherDataCallback = new Callback<WeatherData>() {
            @Override
            public void success(WeatherData weatherData, Response response) {
                Log.d("JK", "Success: weatherData: base: " + weatherData.getName() +
                        " cod: " + weatherData.getCod());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("JK", "Failure: err:" + error);
            }
        };


        public void runRetrofitTestAsync() {
            if (mGetWeatherRestAdapter == null)
                mGetWeatherRestAdapter = new GetWeatherRestAdapter();
            mGetWeatherRestAdapter.testWeatherApiAsync("HorniPocernice", "f51c090018cb53eaa363389cb68e5bdf", mWeatherDataCallback);
        }


    };




}
