package org.bebra.oscarserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OscarServer {

    public static void main(String[] args) {
        SpringApplication.run(OscarServer.class, args);
    }

}
