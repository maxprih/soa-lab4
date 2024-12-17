package org.bebra.oscarrestgateway.web;

import org.bebra.oscarrestgateway.util.PersonXmlMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * @author max_pri
 */
@Configuration
public class OscarClientConfig {

    @Value("${oscar-server.url}")
    private String oscarServiceUrl;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("org.bebra.soacommons.model.soap");
        return marshaller;
    }

    @Bean
    public UnsafeHttpsUrlConnectionMessageSender messageSender() {
        return new UnsafeHttpsUrlConnectionMessageSender();
    }

    @Bean
    public OscarClient oscarClient(Jaxb2Marshaller marshaller, UnsafeHttpsUrlConnectionMessageSender sender) {
        OscarClient client = new OscarClient();
        client.setDefaultUri(oscarServiceUrl);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setMapper(new PersonXmlMapper());
        client.setMessageSender(sender);
        return client;
    }
}
