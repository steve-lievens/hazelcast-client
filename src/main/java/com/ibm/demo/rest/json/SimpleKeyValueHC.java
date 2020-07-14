package com.ibm.demo.rest.json;

import com.hazelcast.core.HazelcastInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ConcurrentMap;

import java.util.logging.Logger;

@Path("/hazelcast")
public class SimpleKeyValueHC {

    private final Logger logger = Logger.getLogger(SimpleKeyValueHC.class.getName());


    @Inject
    HazelcastInstance hazelcastInstance;

    private ConcurrentMap<String, String> retrieveMap() {
        return hazelcastInstance.getMap("map2");
    }

    @POST
    @Path("/put")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleKeyValueBean put(@QueryParam("key") String key, @QueryParam("value") String value) {
        logger.info("Starting POST");
        retrieveMap().put(key, value);
        logger.info("Ending POST");
        return new SimpleKeyValueBean(key, value);
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleKeyValueBean get(@QueryParam("key") String key) {
        logger.info("Starting GET");
        String value = retrieveMap().get(key);
        logger.info("Ending GET");
        return new SimpleKeyValueBean(key, value);
    }
}