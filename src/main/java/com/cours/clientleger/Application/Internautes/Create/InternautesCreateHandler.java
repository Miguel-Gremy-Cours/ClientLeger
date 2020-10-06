package com.cours.clientleger.Application.Internautes.Create;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InternautesCreateHandler {
    public void CreateInternautes(Map<String, String> data) throws Exception {
        InternautesCreateRequest internautesCreateRequest = new InternautesCreateRequest();
        internautesCreateRequest.CreateInDatabaseRequest(data);
    }
}
