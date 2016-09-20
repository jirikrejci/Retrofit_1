package com.example.Mockup;

import com.example.DataStructures.NewAssociationResponse;

/**
 * Created by Jirka on 20.9.2016.
 */
public class NewAssociationMockup {

    public static NewAssociationResponse geNewAssotiationResonse (){
        NewAssociationResponse newAssociationResponse = new NewAssociationResponse("SampleString1", "AppId Sample Str", "Personal ID sample Str", Boolean.TRUE, "Message Str"  );
        System.out.println(newAssociationResponse.toString());
        return newAssociationResponse;
    }

}
