package com.ibm.demo.rest.json;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.Startup;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientConnectionStrategyConfig;

import com.hazelcast.core.HazelcastInstance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import java.util.logging.Logger;

@Startup
@ApplicationScoped
public class HazelcastClientConfig {

    private final Logger logger = Logger.getLogger(HazelcastClientConfig.class.getName());
    private HazelcastInstance hc_instance;

    @ConfigProperty(name = "HC_ADDRESS")
    private String hcClusterAddress;

    void onStart(@Observes StartupEvent ev) {               
        logger.info("The application is starting...");
        logger.info("Hazelcast client connecting to : " + hcClusterAddress);
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress(hcClusterAddress);
        clientConfig.getConnectionStrategyConfig().setReconnectMode(ClientConnectionStrategyConfig.ReconnectMode.ON);
        hc_instance = HazelcastClient.newHazelcastClient(clientConfig);
        logger.info("Hazelcast client connected to cluster node " + hc_instance.getName());
    }

    void onStop(@Observes ShutdownEvent ev) {               
        logger.info("The application is stopping...");
    }

    @Produces
    HazelcastInstance createInstance() {
    
        return hc_instance;
    }
}