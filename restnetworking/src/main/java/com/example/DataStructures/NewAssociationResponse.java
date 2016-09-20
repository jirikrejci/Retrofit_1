package com.example.DataStructures;

/**
 * Created by Jirka on 20.9.2016.
 */
public class NewAssociationResponse {

    public AgentId agentId = new AgentId();
    public AppPersonalId appPersonalId = new AppPersonalId();
    public Boolean isSuccess;
    public String message;


    public class AgentId {
        String asGuid;
    }

    public class AppPersonalId {
        String appId;
        String personalID;
    }

    /**
     * Constructor
     * @param asGuid
     * @param appID
     * @param personalID
     * @param isSuccess
     * @param message
     */
    public NewAssociationResponse (String asGuid, String appID, String personalID, Boolean isSuccess, String message) {
        this.agentId.asGuid = asGuid;
        this.appPersonalId.appId = appID;
        this.appPersonalId.personalID = personalID;
        this.isSuccess = isSuccess;
        this.message = message;
    }

}
