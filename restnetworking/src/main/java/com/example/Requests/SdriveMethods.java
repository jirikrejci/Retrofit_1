package com.example.Requests;

import com.example.DataStructures.AgentIdResponse;
import com.example.EndpointDefinitions.SdriveService;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jirka on 20.9.2016.
 */
public class SdriveMethods {

    public static AgentIdResponse getAgentIdCall() {
        AgentIdResponse agentIdResponse = null;

        // Intercepting
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        // nový bulder kvůli JSON
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://myskodadev.azurewebsites.net")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SdriveService sdriveService = retrofit.create(SdriveService.class);

        //SdriveService sdriveService = SdriveService.retrofit.create(SdriveService.class);
        Call<AgentIdResponse> call = sdriveService.getAgentId();
        try {
            agentIdResponse = call.execute().body();
            System.out.println("AgentID: " + agentIdResponse.getAgentID());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return agentIdResponse;
   }

    public static String getAgentIdResponseBodyCall() {
        // Intercepting

        String outputStr = null;

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://myskodadev.azurewebsites.net")
                .client(client)
                .build();


        SdriveService sdriveService = retrofit.create(SdriveService.class);

        Call<ResponseBody> call = sdriveService.getAgentIdBody();
        try {
            ResponseBody responseBody = call.execute().body();

            System.out.println("Response body: " + responseBody.string());
            outputStr = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStr;
    }

    public static void getAgentId_async () {

        SdriveService sdriveService = SdriveService.retrofit.create(SdriveService.class);
        Call<AgentIdResponse> call = sdriveService.getAgentId();
        call.enqueue(new Callback<AgentIdResponse>() {
            AgentIdResponse agentIdResponse;
            @Override
            public void onResponse (Call<AgentIdResponse> call, Response<AgentIdResponse> response) {
                System.out.println("AgentId: " + response.body().getAgentID());
                agentIdResponse = response.body();
            }

            @Override
            public void onFailure(Call<AgentIdResponse> call, Throwable t) {
                System.out.println(t.toString());
            }
        });

    }

}