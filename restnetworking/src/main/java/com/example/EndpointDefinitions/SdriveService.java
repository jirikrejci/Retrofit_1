package com.example.EndpointDefinitions;

import com.example.DataStructures.AgentIdResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by jirikrejci on 19.09.16.
 */



    public interface SdriveService {
        // Request method and URL specified in the annotation
        // Callback for the parsed response is the last parameter

        @GET("api/Sdrive/GetAgentID")
        Call<ResponseBody> getAgentIdBody(@Header("deviceId") String deviceid, @Header("X-SkodaGW-Version") String xSkodaGwVersion);

        @Headers({"deviceId: 7CD11DF3E4964E97B49B37214DCDBAFF", "X-SkodaGW-Version: 1"})
        @GET("api/Sdrive/GetAgentID")
        Call<ResponseBody> getAgentIdBody();


        @Headers({"deviceId: 7CD11DF3E4964E97B49B37214DCDBAFF", "X-SkodaGW-Version: 1"})
        @GET("api/Sdrive/GetAgentID")
        Call<AgentIdResponse> getAgentId ();




/*        public static final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://myskodadev.azurewebsites.net")
                .build();
                //.addConverterFactory(GsonConverterFactory.create())
*/
    }






