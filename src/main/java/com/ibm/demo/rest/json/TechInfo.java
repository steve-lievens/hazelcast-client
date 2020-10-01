package com.ibm.demo.rest.json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.logging.Logger;
import java.util.Collection;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastJsonValue;
import com.hazelcast.core.DistributedObject;
import com.hazelcast.map.IMap;


@Path("/techinfo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TechInfo {
    private final Logger logger = Logger.getLogger(UIModifier.class.getName());

    @ConfigProperty(name = "UI_LOGOURL")
    private String logoURL;

    @Inject
    HazelcastInstance hazelcastInstance;

    @Path("/getoverview")
    @GET
    public Response getOverview() {
        logger.info("Retrieving techinfo overview");
        String jsonReturn = "[";
        int counter = 1;

        logger.info("Retrieving maps from Hazelcast IMDG cluster :");
        Collection<DistributedObject> distributedObjects = hazelcastInstance.getDistributedObjects();
        for (DistributedObject object : distributedObjects) {
            if (object instanceof IMap) {
                String mapname = object.getName();
                int mapsize = hazelcastInstance.getMap(mapname).size();
                if(counter != 1){
                    jsonReturn += ",";
                }
                jsonReturn += "{\"id\":\"" + Integer.toString(counter) + "\",\"mapname\":\"" + mapname + "\",\"mapcount\":\"" + Integer.toString(mapsize) + "\"}";
                logger.info("Found map : " + mapname + ", size : " + Integer.toString(mapsize));
                counter++;
            }
        }


        jsonReturn += "]";
        logger.info("returning : " + jsonReturn);

        return Response.status(200).entity(jsonReturn).build();
    }
    
    @Path("/clearmaps")
    @GET
    public Response clearMaps() {
        logger.info("Doing a clear map on all maps !!!");
        String jsonReturn = "{}";

        logger.info("Retrieving maps from Hazelcast IMDG cluster :");
        Collection<DistributedObject> distributedObjects = hazelcastInstance.getDistributedObjects();
        for (DistributedObject object : distributedObjects) {
            if (object instanceof IMap) {
                String mapname = object.getName();
                IMap<String, HazelcastJsonValue> map = hazelcastInstance.getMap(mapname);
                int mapsize = map.size();
                logger.info("Found map : " + mapname + ", size : " + Integer.toString(mapsize) + ". Clearing it now ...");
                map.clear();
            }
        }
        
        return Response.status(200).entity(jsonReturn).build();
    }
}
