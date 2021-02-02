package com.ibm.demo.rest.json;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TransactionSource {
    private final Logger logger = Logger.getLogger(TransactionSource.class.getName());
    
    private JSONArray transactions;
    private boolean dataLoaded = false;

    @ConfigProperty(name = "API_DATAFILE")
    private String dataFILE;

    private void loadData() {
        try {
            // The class loader that loaded the class
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(dataFILE);

            if (inputStream == null) {
                throw new IllegalArgumentException("file not found! ");
            } else {
                logger.info("We have the file !!!");
                String result = IOUtils.toString(inputStream, "UTF-8");
               
                logger.info("Loading initial data into the array");
                transactions = new JSONArray(result); 
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
        if(!dataLoaded){
            loadData();
            dataLoaded = true;
        }

        jsonReturn = transactions.toString();
        return Response.status(200).entity(jsonReturn).build();
    }

    @Path("/addTransaction")
    @GET
    public Response addTransaction() {
        logger.info("adding a bank transaction - simulation");
        JSONObject transaction = new JSONObject();
        transaction.put("DATE",20200101);
        transaction.put("CLIENT_ID",9450);
        transaction.put("ACCOUNT_ID",7632);
        transaction.put("OPERATION","CREDIT IN CASH");
        transaction.put("AMOUNT",1000);
        transaction.put("K_SYMBOL","");
        transaction.put("ROW",5426568);
        transaction.put("TRANS_ID",2456844);
        transaction.put("TYPE","CREDIT");
        transaction.put("BALANCE",10000);
        transactions.put(transaction);

        return Response.status(201).build();
    }

}


