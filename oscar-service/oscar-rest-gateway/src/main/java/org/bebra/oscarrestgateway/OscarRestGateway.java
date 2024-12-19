package org.bebra.oscarrestgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OscarRestGateway {

    public static void main(String[] args) {
        SpringApplication.run(OscarRestGateway.class, args);
    }

}
