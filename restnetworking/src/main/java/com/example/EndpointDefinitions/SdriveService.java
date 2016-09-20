package com.example.EndpointDefinitions;

import com.example.DataStructures.AgentIdResponse;
import com.example.DataStructures.NewAssociationRequest;
import com.example.DataStructures.NewAssociationResponse;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by jirikrejci on 19.09.16.
 */



    public interface SdriveService {
        // Request method and URL specified in the annotation
        // Callback for the parsed response is the last parameter

    /**
     * GetAgentID s parametry pro header - vrací ResponseBody
      * @param deviceid
     * @param xSkodaGwVersion
     * @return ResponseBody
     */
        @GET("api/Sdrive/GetAgentID")
        Call<ResponseBody> getAgentIdBody(@Header("deviceId") String deviceId, @Header("X-SkodaGW-Version") String xSkodaGwVersion);

    /**
     * GetAgentID s implivitními parametry pro header, vrací ResponseBody
     * @return
     */

        @Headers({"deviceId: 7CD11DF3E4964E97B49B37214DCDBAFF", "X-SkodaGW-Version: 1"})
        @GET("api/Sdrive/GetAgentID")
        Call<ResponseBody> getAgentIdBody();

    /**
     * GetAgentId vrací AgentIdResponse
     * @return
     */
        @Headers({"deviceId: 7CD11DF3E4964E97B49B37214DCDBAFF", "X-SkodaGW-Version: 1"})
        @GET("api/Sdrive/GetAgentID")
        Call<AgentIdResponse> getAgentId ();


    /**
     * NewAssociation vrací AgentIdResponse
     * @return
     */
    @Headers({"deviceId: 7CD11DF3E4964E97B49B37214DCDBAFF", "X-SkodaGW-Version: 1"})
    @POST("api/Sdrive/NewAssociation")
    Call<NewAssociationResponse> postNewAssociation (@Body NewAssociationRequest newAssociationRequest);






    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        public static final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://myskodadev.azurewebsites.net")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

    }






