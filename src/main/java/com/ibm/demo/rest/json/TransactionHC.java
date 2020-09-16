package com.ibm.demo.rest.json;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastJsonValue;
import com.hazelcast.core.DistributedObject;
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

    @ConfigProperty(name = "HC_MAPNAME")
    private String transactionMapName;

    @ConfigProperty(name = "CLIENT_ID")
    private String clientID;

    @Inject
    HazelcastInstance hazelcastInstance;

    private IMap<String, HazelcastJsonValue> retrieveMap(String i_mapname) {
        logger.info("Working with map " + i_mapname);
        return hazelcastInstance.getMap(i_mapname);
    }

    // Creates a new transaction (only used to build demo data)
    @Path("/create")
    @POST
    public Response create(@QueryParam("key") String key, TransactionBean t) {
        String mapname;
        if(key != null){
            mapname = key;
        } else {
            mapname = transactionMapName;
        }
            
        logger.info("Creating transaction in map " + mapname);
        logger.info(t.toString());
        retrieveMap(mapname).put(t.getROW(), new HazelcastJsonValue(t.toString()));
        logger.info("Transaction written to map");
        return Response.status(201).build(); 
    }

    // Creates a new transaction (only used to build demo data)
    @Path("/createbatch")
    @POST
    public Response createBatch(@QueryParam("key") String key, List<TransactionBean> batch) {
        String mapname;
        if(key != null){
            mapname = key;
        } else {
            mapname = transactionMapName;
        }
            
        logger.info("Creating transactions from batch in map " + mapname);
        IMap<String, HazelcastJsonValue> imdgmap = retrieveMap(mapname);
        
        for (TransactionBean transaction: batch) {
            logger.info(transaction.toString());
            imdgmap.put(transaction.getROW(), new HazelcastJsonValue(transaction.toString()));
        }
        
        logger.info("Transactions written to map");
        return Response.status(201).build(); 
    }

    // Retrieve all transactions of a single client. (By Client ID)
    // Needs a "key" query parameter which is equal to the client id.
    @Path("/getByClient")
    @GET
    public Response getByClient(@QueryParam("key") String key) {
        // For now we get the full data set in one go. 
        // If this becomes too big, we'll need to add start and end info based on the pagination

        // When no parameter is specified, we take the client id from the app properties.
        if(key == null){
            key = clientID;
        }

        Collection<HazelcastJsonValue> transactionsCredit = retrieveMap(transactionMapName).values(Predicates.equal("CLIENT_ID", key));

        List<String> transactions = new ArrayList<String>();

        logger.info("Listing transactions for client : " + key);
        for (HazelcastJsonValue transactionCredit: transactionsCredit) {
            //logger.info("> " + transactionCredit.toString());
            transactions.add(transactionCredit.toString());
        }

        logger.info(transactions.toString());

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

    @Path("/getAllData")
    @GET
    public Response getAllData(@QueryParam("limitby") int limit) {
        // For now we get the full data set in one go. 
        // If this becomes too big, we'll need to add start and end info based on the pagination
        IMap<String, HazelcastJsonValue> map = retrieveMap(transactionMapName);
        List<String> transactions = new ArrayList<String>();

        logger.info("Listing all transactions ");
        int[] ln = new int[1];
        if (limit > 0)
					map	.values()
						.stream()
						.limit(limit)
						.forEach(v -> {
							System.out.println(String.format("%06d", ln[0]++) + ": " + v.toString());
						});
				else
					map	.values()
						.stream()
						.forEach(v -> {
							System.out.println(String.format("%06d", ln[0]++) + ": " + v.toString());
						});

        /*
        for (HazelcastJsonValue transactionCredit: transactionsCredit) {
            //logger.info("> " + transactionCredit.toString());
            transactions.add(transactionCredit.toString());
        }

        logger.info(transactions.toString());
*/
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

    @Path("/delete")
    @DELETE
    public Response delete(@QueryParam("key") String key) {
        logger.info("Deleting map :" + key);
        retrieveMap(key).destroy();
        return Response.status(201).build(); 
    }

    @Path("/getMaps")
    @GET
    public Response getMaps() {
        logger.info("Retrieving maps from Hazelcast IMDG cluster :");
        Collection<DistributedObject> distributedObjects = hazelcastInstance.getDistributedObjects();
        for (DistributedObject object : distributedObjects) {
            if (object instanceof IMap) {
                logger.info("Found map : " + object.getName());
            }
        }

        return Response.status(201).build(); 
    }

}