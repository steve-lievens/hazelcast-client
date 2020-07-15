package com.ibm.demo.rest.json;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.DistributedObject;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

@Path("/hazelcast")
public class SimpleKeyValueHC {

    private final Logger logger = Logger.getLogger(SimpleKeyValueHC.class.getName());


    @Inject
    HazelcastInstance hazelcastInstance;

    private ConcurrentMap<String, String> retrieveMap(String i_mapname) {
        return hazelcastInstance.getMap(i_mapname);
    }

    @POST
    @Path("/put")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleKeyValueBean put(@QueryParam("key") String key, @QueryParam("value") String value) {
        logger.info("Writing bean to map with key " + key);
        retrieveMap("map2").put(key, value);
        logger.info("Write done.");
        return new SimpleKeyValueBean(key, value);
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleKeyValueBean get(@QueryParam("key") String key) {
        logger.info("Reading bean from map with key" + key);
        String value = retrieveMap("map2").get(key);
        logger.info("Read done.");
        return new SimpleKeyValueBean(key, value);
    }

    @GET
    @Path("/listmaps")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleKeyValueBean listmaps() {
        logger.info("Starting GET maps");

        String mapnames = "";
        
        Collection<DistributedObject> distributedObjects = hazelcastInstance.getDistributedObjects();
        for (DistributedObject object : distributedObjects) {
            if (object instanceof ConcurrentMap) {
                logger.info("Found map with name " + object.getName());
                mapnames += object.getName() + " - ";
            }
        }

        logger.info("Ending GET maps");
        return new SimpleKeyValueBean("maps", mapnames);
    }

    @GET
    @Path("/deletemap")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleKeyValueBean deletemap(@QueryParam("key") String key) {
        logger.info("Deleting map with key" + key);
        hazelcastInstance.getMap(key).destroy();
        logger.info("Delete done.");
        return new SimpleKeyValueBean("mapname", key);
    }


}