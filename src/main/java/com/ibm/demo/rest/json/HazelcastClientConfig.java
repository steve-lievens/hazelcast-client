package com.ibm.demo.rest.json;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.Startup;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientConnectionStrategyConfig;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.DistributedObject;
import com.hazelcast.map.IMap;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import java.util.logging.Logger;
import java.util.Collection;

@Startup
@ApplicationScoped
public class HazelcastClientConfig {

    private final Logger logger = Logger.getLogger(HazelcastClientConfig.class.getName());
    private HazelcastInstance hc_instance;

    @ConfigProperty(name = "HC_ADDRESS")
    private String hcClusterAddress;
    @ConfigProperty(name = "HC_CLUSTERNAME")
    private String hcClusterName;
    @ConfigProperty(name = "HC_MAPNAME")
    private String hcMapName;
    @ConfigProperty(name = "CLIENT_ID")
    private String clientID;
    @ConfigProperty(name = "ACCOUNT_ID")
    private String accountID;

    void onStart(@Observes StartupEvent ev) {
        logger.info("-----------------------------------------------------------------------------------");
        logger.info("Application startup sequence - Build 22");
        logger.info("The application is using environment variables :");
        logger.info("HAZELCAST_HOST=" + System.getenv("HAZELCAST_HOST"));
        logger.info("HAZELCAST_CLUSTERNAME=" + System.getenv("HAZELCAST_CLUSTERNAME"));
        logger.info("HAZELCAST_MAPNAME=" + System.getenv("HAZELCAST_MAPNAME"));
        logger.info("CLIENT_IDENTIFIER=" + System.getenv("CLIENT_IDENTIFIER"));
        logger.info("ACCOUNT_IDENTIFIER=" + System.getenv("ACCOUNT_IDENTIFIER"));

        logger.info("If these environment variables aren't present,");
        logger.info("the app reverts to its defaults specified in application.properties.");
        logger.info("Hazelcast client connecting to address : " + hcClusterAddress);
        logger.info("Hazelcast client connecting cluster : " + hcClusterName);
        logger.info("Hazelcast client is using map : " + hcMapName);
        logger.info("Transactions used are from client id : " + clientID);
        logger.info("Transactions used are from account id : " + accountID);

        
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName(hcClusterName);
        clientConfig.getNetworkConfig().addAddress(hcClusterAddress);
        clientConfig.getConnectionStrategyConfig().setReconnectMode(ClientConnectionStrategyConfig.ReconnectMode.ON);
        hc_instance = HazelcastClient.newHazelcastClient(clientConfig);
        logger.info("Hazelcast client connected to cluster node " + hc_instance.getName());
        logger.info("Listing maps from Hazelcast IMDG cluster :");
        Collection<DistributedObject> distributedObjects = hc_instance.getDistributedObjects();
        for (DistributedObject object : distributedObjects) {
            if (object instanceof IMap) {
                String mapname = object.getName();
                int mapsize = hc_instance.getMap(mapname).size();
                logger.info("Found map : " + mapname + ", size : " + Integer.toString(mapsize));
            }
        }
        
        logger.info("Application startup sequence ended - Build 22");
        logger.info("-----------------------------------------------------------------------------------");
    }

    void onStop(@Observes ShutdownEvent ev) {
        logger.info("The application is stopping...");
    }

    @Produces
    HazelcastInstance createInstance() {
        return hc_instance;
    }
}