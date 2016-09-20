package com.example.DataStructures;

/**
 * Created by Jirka on 20.9.2016.
 */
public class NewAssociationRequest {
    String agentID;
    String ssoID;

    public NewAssociationRequest(String agentID, String ssoID) {
        this.agentID = agentID;
        this.ssoID = ssoID;
    }

    @Override
    public String toString() {
        return "NewAssociationRequest{" +
                "\n\tagentID='" + agentID + '\'' +
                "\n\tssoID='" + ssoID + '\'' +
                '}';
    }
}
