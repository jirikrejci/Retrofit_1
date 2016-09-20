package com.example;

import com.example.DataStructures.AgentIdResponse;
import com.example.Requests.SdriveMethods;

public class SdriveTest {
    public static void main (String [] args) {

        System.out.println("Sdrive Tests Beginning");

        String response = SdriveMethods.getAgentIdResponseCall();
        AgentIdResponse agentIdResponse = SdriveMethods.getAgentIdCall();







    }
}
