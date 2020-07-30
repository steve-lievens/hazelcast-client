package com.ibm.demo.rest.json;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastJsonValue;
import com.hazelcast.map.IMap;
import com.hazelcast.query.Predicates;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.Collection;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import javax.ws.rs.core.MediaType;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionHC {
    private final Logger logger = Logger.getLogger(TransactionHC.class.getName());
    private final String transactionMapName = "TransactionsMap";

    @Inject
    HazelcastInstance hazelcastInstance;

    private IMap<String, HazelcastJsonValue> retrieveMap(String i_mapname) {
        return hazelcastInstance.getMap(i_mapname);
    }

    @Path("/create")
    @POST
    public Response create(TransactionBean t) {
        logger.info("Creating transaction :");
        logger.info(t.toString());
        retrieveMap(transactionMapName).put(t.getRow_number(), new HazelcastJsonValue(t.toString()));
        logger.info("Transaction written to map");
        return Response.status(201).build(); 
    }

    @Path("/getByClient")
    @GET
    public Response getByClient(@QueryParam("key") String key) {
        Collection<HazelcastJsonValue> transactionsCredit = retrieveMap(transactionMapName).values(Predicates.equal("client_id", key));
        //TransactionsBean tb = new TransactionsBean();
        List<String> transactions = new ArrayList<String>();

        logger.info("Listing transactions for client : " + key);
        for (HazelcastJsonValue transactionCredit: transactionsCredit) {
            //logger.info("> " + transactionCredit.toString());
            transactions.add(transactionCredit.toString());
        }

        logger.info(transactions.toString());
        //return transactions.toString();

        // Adding a response with extra headers for CORS
        return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(transactions.toString())
            .build();
    }

}