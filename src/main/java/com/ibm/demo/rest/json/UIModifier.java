package com.ibm.demo.rest.json;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.logging.Logger;



@Path("/ui")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UIModifier {
    private final Logger logger = Logger.getLogger(UIModifier.class.getName());

    @ConfigProperty(name = "UI_LOGOURL")
    String logoURL;

    @ConfigProperty(name = "UI_TABLEHEADER")
    String tableHeader;

    @Path("/getlogourl")
    @GET
    public Response getLogoURL() {
        logger.info("Retrieving Logo URL.");
        logger.info("URL is : " + logoURL);

        String jsonReturn = "{\"logourl\":\"" + logoURL + "\"}";
        logger.info("returning : " + jsonReturn);

        return Response.status(200).entity(jsonReturn).build();
    }    

    @Path("/getheader")
    @GET
    public Response getHeader() {
        logger.info("Retrieving Table Header.");
        logger.info("URL is : " + tableHeader);

        String jsonReturn = "{\"tableheader\":\"" + tableHeader + "\"}";
        logger.info("returning : " + jsonReturn);

        return Response.status(200).entity(jsonReturn).build();
    }    

}