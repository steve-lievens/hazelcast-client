package com.ibm.demo.rest.json;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.logging.Logger;
import java.util.Collection;
import java.util.Set;

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

    private IMap<Integer, HazelcastJsonValue> retrieveMap(String i_mapname) {
        logger.info("Working with map " + i_mapname);
        return hazelcastInstance.getMap(i_mapname);
    }

    @Path("/getoverview")
    @GET
    public Response getOverview() {
        logger.info("Retrieving techinfo overview");
        String jsonReturn = "[";
        int counter = 1;

        logger.info("Retrieving maps from Hazelcast IMDG cluster :");
        Collection<DistributedObject> distributedObjects = hazelcastInstance.getDistributedObjects();

        // Loop over the maps
        for (DistributedObject object : distributedObjects) {
            if (object instanceof IMap) {
                // Get info of the map
                String mapname = object.getName();
                IMap<Integer, HazelcastJsonValue> map = retrieveMap(mapname);
                int mapsize = map.size();
                String mapsample = "";
                logger.info(mapname + " size : " + Integer.toString(mapsize));

                // If the map is empty, don't look for a sample
                if (mapsize == 0) {
                    logger.info("Empty map. No sample");
                    mapsample = "\"\"";
                } else {
                    // Get a key from the map and retrieve the object with that key
                    Set<Integer> mapkeys = map.keySet();
                    Object[] mapkeysarray = mapkeys.toArray();
                    Integer samplekey = Integer.parseInt(mapkeysarray[0].toString());
                    logger.info("Sample Key value : " + samplekey.toString());
                    HazelcastJsonValue samplevalue = map.get(samplekey);
                    mapsample = samplevalue.toString();
                    logger.info("Sample value : " + mapsample);
                }
                if (counter != 1) {
                    jsonReturn += ",";
                }
                jsonReturn += "{\"id\":\"" + Integer.toString(counter) + "\",\"mapname\":\"" + mapname
                        + "\",\"mapcount\":\"" + Integer.toString(mapsize) + "\",\"mapsample\":" + mapsample + "}";
                
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
                logger.info(
                        "Found map : " + mapname + ", size : " + Integer.toString(mapsize) + ". Clearing it now ...");
                map.clear();
            }
        }

        return Response.status(200).entity(jsonReturn).build();
    }
}
