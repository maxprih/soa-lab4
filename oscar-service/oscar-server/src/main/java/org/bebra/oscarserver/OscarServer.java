package org.bebra.oscarserver;

import org.bebra.oscarserver.configuration.RibbonClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
@EnableEurekaClient
@RibbonClients(defaultConfiguration = RibbonClientConfig.class)
public class OscarServer {

    public static void main(String[] args) {
        SpringApplication.run(OscarServer.class, args);
    }

}
