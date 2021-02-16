package com.ibm.demo.rest.json;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.inject.Inject;
import javax.ws.rs.*;

import org.json.JSONArray;
import org.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastJsonValue;
import com.hazelcast.map.IMap;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TransactionSource {
    private final Logger logger = Logger.getLogger(TransactionSource.class.getName());

    private JSONArray transactions;
    private JSONArray transactionsSmall;
    private boolean dataLoaded = false;

    @ConfigProperty(name = "HC_MAPNAME")
    String transactionMapName;

    @ConfigProperty(name = "API_DATAFILE")
    String dataFILE;

    @ConfigProperty(name = "API_DATAFILE_SMALL")
    String dataFILESMALL;

    @Inject
    HazelcastInstance hazelcastInstance;

    private IMap<Integer, HazelcastJsonValue> retrieveMap(String i_mapname) {
        logger.info("Working with map " + i_mapname);
        return hazelcastInstance.getMap(i_mapname);
    }

    private void loadData() {
        try {
            // The class loader that loaded the class
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(dataFILE);
            InputStream inputStreamSmall = classLoader.getResourceAsStream(dataFILESMALL);

            if (inputStream == null) {
                throw new IllegalArgumentException("file not found! ");
            } else {
                logger.info("We have the file !!!");
                String result = IOUtils.toString(inputStream, "UTF-8");

                logger.info("Loading initial data into the array");
                transactions = new JSONArray(result);
            }

            if (inputStreamSmall == null) {
                throw new IllegalArgumentException("file not found! ");
            } else {
                logger.info("We have the small file !!!");
                String result = IOUtils.toString(inputStreamSmall, "UTF-8");
                logger.info(result);
                logger.info("Loading initial data into the array");
                transactionsSmall = new JSONArray(result);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Path("/transactions")
    @GET
    public Response getTransactions() {
        logger.info("Returning bank transactions - simulation");
        String jsonReturn = "";

        // Load the data on first access
        if (!dataLoaded) {
            loadData();
            dataLoaded = true;
        }

        jsonReturn = transactions.toString();
        return Response.status(200).entity(jsonReturn).build();
    }

    @Path("/transactionssmall")
    @GET
    public Response getTransactionsSmall() {
        logger.info("Returning bank transactions (small) - simulation");
        String jsonReturn = "";

        // Load the data on first access
        if (!dataLoaded) {
            loadData();
            dataLoaded = true;
        }

        jsonReturn = transactionsSmall.toString();
        return Response.status(200).entity(jsonReturn).build();
    }

    @Path("/addTransaction")
    @GET
    public Response addTransaction() {
        logger.info("adding a bank transaction - simulation");
        JSONObject transaction = new JSONObject();
        transaction.put("DATE", 20200101);
        transaction.put("CLIENT_ID", 9450);
        transaction.put("ACCOUNT_ID", 7632);
        transaction.put("OPERATION", "CREDIT IN CASH");
        transaction.put("AMOUNT", 1000);
        transaction.put("K_SYMBOL", "");
        transaction.put("ROW", 5426568);
        transaction.put("TRANS_ID", 2456844);
        transaction.put("TYPE", "CREDIT");
        transaction.put("BALANCE", 10000);
        transactions.put(transaction);

        return Response.status(201).build();
    }

    // Intial Fill of the map to have demo data - for local development ... only 10 transactions to reduce the upload time.
    @Path("/loadDemoDataSmall")
    @GET
    public Response loadDemoDataSmall(@QueryParam("key") String key) {
        // Load the data on first access
        if (!dataLoaded) {
            loadData();
            dataLoaded = true;
        }

        String mapname;
        if (key != null) {
            mapname = key;
        } else {
            mapname = transactionMapName;
        }

        logger.info("Creating transactions from small data set in map " + mapname);
        IMap<Integer, HazelcastJsonValue> imdgmap = retrieveMap(mapname);

        for (int i = 0; i < transactionsSmall.length(); i++) {
            JSONObject transaction = transactionsSmall.getJSONObject(i);
            imdgmap.put(transaction.getInt("ROW"), new HazelcastJsonValue(transaction.toString()));
        }

        logger.info(Integer.toString(transactionsSmall.length()) + " transactions written to map");
        return Response.status(201).build();
    }

    // Intial Fill of the map to have demo data
    @Path("/loadDemoData")
    @GET
    public Response loadDemoData(@QueryParam("key") String key) {
        // Load the data on first access
        if (!dataLoaded) {
            loadData();
            dataLoaded = true;
        }

        String mapname;
        if (key != null) {
            mapname = key;
        } else {
            mapname = transactionMapName;
        }

        logger.info(Integer.toString(transactions.length()) + " transactions written to map");
        IMap<Integer, HazelcastJsonValue> imdgmap = retrieveMap(mapname);

        for (int i = 0; i < transactions.length(); i++) {
            JSONObject transaction = transactions.getJSONObject(i);
            logger.info(transaction.toString());
            imdgmap.put(transaction.getInt("ROW"), new HazelcastJsonValue(transaction.toString()));
        }

        logger.info("Transactions written to map");
        return Response.status(201).build();
    }

}
