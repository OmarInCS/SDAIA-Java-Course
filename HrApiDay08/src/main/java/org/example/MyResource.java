package org.example;

import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

import java.time.LocalDate;

/**
 * Root resource (exposed at "myresource" path)
 */

@Singleton
@Path("myresource")
public class MyResource {

    int count = 0;
//    @HeaderParam("apiKey") String apiKey; // Error
//    @CookieParam("username") String username; // Error
    @Context HttpHeaders headers;
    @Context UriInfo uriInfo;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(
            @HeaderParam("apiKey") String apiKey,
            @CookieParam("username") String username
//            , @Context HttpHeaders headers,
//            @Context UriInfo uriInfo
            ) {

        System.out.println(headers.getDate());
        System.out.println(headers.getLanguage());
        System.out.println(headers.getMediaType());
        System.out.println(headers.getCookies());
        System.out.println("---------------");
        System.out.println(uriInfo.getAbsolutePath());
        System.out.println(uriInfo.getPathSegments());
        System.out.println(uriInfo.getQueryParameters());
        System.out.println(uriInfo.getQueryParameters().get("locId"));

        count += 1;

        return "Got it! " + count + " name: " + username + " , apiKey: " + apiKey;
    }


    @GET
    @Path("{day}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDate(@PathParam("day") LocalDate day) {
        return "The date is: " + day;
    }


}
