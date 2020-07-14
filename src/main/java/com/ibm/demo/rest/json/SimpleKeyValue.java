package com.ibm.demo.rest.json;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/simplekv")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SimpleKeyValue {

    private Set<SimpleKeyValueBean> kvs = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public SimpleKeyValue() {
        kvs.add(new SimpleKeyValueBean("Apple", "Winter fruit"));
        kvs.add(new SimpleKeyValueBean("Pineapple", "Tropical fruit"));
    }

    @GET
    public Set<SimpleKeyValueBean> list() {
        return kvs;
    }

    @POST
    public Set<SimpleKeyValueBean> add(SimpleKeyValueBean kvb) {
        kvs.add(kvb);
        return kvs;
    }

    @DELETE
    public Set<SimpleKeyValueBean> delete(SimpleKeyValueBean kvb) {
        kvs.removeIf(existingFruit -> existingFruit.name.contentEquals(kvb.name));
        return kvs;
    }
}