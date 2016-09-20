package com.example;

import com.example.DataStructures.AgentIdResponse;
import com.example.EndpointDefinitions.SdriveService;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SdriveTest {
    public static void main (String [] args) {

        System.out.println("Sdrive Tests Beginning");

        // Intercepting
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        /*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://myskodadev.azurewebsites.net")
                .client(client)             // lze i .client(new OkHttpClient())
                .build();

                */
/*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://myskodadev.azurewebsites.net")
                .client(new OkHttpClient())
                .build();

                */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://myskodadev.azurewebsites.net")
                .build();

        SdriveService sdriveService = retrofit.create(SdriveService.class);


        //SdriveService sdriveService = SdriveService.retrofit.create(SdriveService.class);

        Call<ResponseBody> call = sdriveService.getAgentIdBody();
        try {
            ResponseBody responseBody = call.execute().body();

            System.out.println("Response body: " + responseBody.string());
        } catch (IOException e) {
            e.printStackTrace();
        }



// nový bulder kvůli JSON
        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("http://myskodadev.azurewebsites.net")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SdriveService sdriveService2 = retrofit2.create(SdriveService.class);

        //SdriveService sdriveService = SdriveService.retrofit.create(SdriveService.class);
        Call<AgentIdResponse>  call2 = sdriveService2.getAgentId();
        try {
            AgentIdResponse agentIdResponse = call2.execute().body();
            System.out.println("AgentID: " + agentIdResponse.getAgentID());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
