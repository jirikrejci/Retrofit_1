package com.example;


import com.example.DataStructures.NewAssociationRequest;
import com.example.DataStructures.NewAssociationResponse;
import com.example.EndpointDefinitions.SdriveService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SdriveTest {

    public static void main (String [] args) {

        System.out.println("Sdrive Tests Beginning");

       // String response = SdriveMethods.getAgentIdResponseBodyCall();    // Get AgentID, vrací body String  WORKING
       // AgentIdResponse agentIdResponse = SdriveMethods.getAgentIdCall();               // Get AgentID vrací AgentIdResponse WORKING
       //SdriveMethods.getAgentId_async();                                             // Get AgentID async volání - vrací AgentIdResponse WORKING


        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        // příprava requestu
        NewAssociationRequest newAssociationRequest = new NewAssociationRequest("859c5d9d-a90e-49ce-b149-6cddd38c42xx", "ssoIDefrrssdd");  //ed
        System.out.println("\nJson newAssociationRequest\n" + gson.toJson(newAssociationRequest, NewAssociationRequest.class));

        SdriveService sdriveService = SdriveService.retrofit.create(SdriveService.class);
        Call<NewAssociationResponse> call = sdriveService.postNewAssociation(newAssociationRequest);
        call.enqueue(new Callback<NewAssociationResponse>() {
            @Override
            public void onResponse(Call<NewAssociationResponse> call, Response<NewAssociationResponse> response) {
                System.out.println("\nPOST NewAssotioation Response: \n" + gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<NewAssociationResponse> call, Throwable t) {
                System.out.println("Post NewAssociation FAILURE");
            }
        });

    }
}
