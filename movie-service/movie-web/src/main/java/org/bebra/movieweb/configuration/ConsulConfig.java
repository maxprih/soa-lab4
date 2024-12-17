package org.bebra.movieweb.configuration;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.agent.Registration;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

import java.util.Collections;

@Startup
@Singleton
public class ConsulConfig {
    String serviceId = "movie-service";
    Consul client;
    AgentClient agentClient;

    @PostConstruct
    void init() {
        client = Consul.builder()
                .withHostAndPort(HostAndPort.fromParts("consul", 8500)).build();
        agentClient = client.agentClient();
        Registration service = ImmutableRegistration.builder()
                .id(serviceId+"-1")
                .name(serviceId)
                .port(8443)
                .address("movie-service")
                .tags(Collections.singletonList("movie-service"))
                .meta(Collections.singletonMap("version", "1.0"))
                .build();

        agentClient.register(service);
    }

    @PreDestroy
    private void deregisterService(){
        agentClient.deregister(serviceId);
    }

}