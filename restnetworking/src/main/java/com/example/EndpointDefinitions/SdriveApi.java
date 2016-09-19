package com.example.EndpointDefinitions;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by jirikrejci on 19.09.16.
 */


public class SdriveApi {
    public interface SdriveInterface {
        // Request method and URL specified in the annotation
        // Callback for the parsed response is the last parameter

        @GET("api/Sdrive/GetAgentID")
        String getAgentId (@Header("deviceId") String deviceid, @Header("X-SkodaGW-Version") String xSkodaGwVersion);

        @Headers({"deviceId: 7CD11DF3E4964E97B49B37214DCDBAFF", "X-SkodaGW-Version: 1"})
        @GET("api/Sdrive/GetAgentID")
        String getAgentId ();




      /*  @GET("group/{id}/users")
        Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);

        @POST("users/new")
        Call<User> createUser(@Body User user);
 */

    }





}
