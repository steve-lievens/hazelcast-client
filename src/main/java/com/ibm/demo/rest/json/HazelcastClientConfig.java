package com.ibm.demo.rest.json;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import java.util.logging.Logger;


@ApplicationScoped
public class HazelcastClientConfig {

    private final Logger logger = Logger.getLogger(HazelcastClientConfig.class.getName());

    @ConfigProperty(name = "HC_ADDRESS")
    private String hcClusterAddress;

    @Produces
    HazelcastInstance createInstance() {
        logger.info("Hazelcast client connecting to : " + hcClusterAddress);
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress(hcClusterAddress);
        return HazelcastClient.newHazelcastClient(clientConfig);
    }
}