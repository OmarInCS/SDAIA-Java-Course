package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.example.services.ApplicationService;
import org.example.services.RequestService;
import org.example.services.SessionService;

@Path("secures")
public class SecureController {


    @GET
    public String getIt() {
        return "Got it: you are in secure controller";
    }
}
