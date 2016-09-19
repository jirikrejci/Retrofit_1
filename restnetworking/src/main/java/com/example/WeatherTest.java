package com.example;

import com.example.EndpointDefinitions.SdriveApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherTest {
    public static void main (String [] args) {

        System.out.println("Weather Tests Beginning");

// nastavení ladění
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        String strURL = "http://myskodadev.azurewebsites.net";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(strURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SdriveApi apiService =
                retrofit.create(SdriveApi.SdriveInterface.class);





        //String username = "sarahjean";
        String userID = apiService.
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int statusCode = response.code();
                User user = response.body();
            }

            @Override
            public void onFailure(String userId, Throwable t) {
                // Log error here since request failed
            }
        });
*/



    }
}
