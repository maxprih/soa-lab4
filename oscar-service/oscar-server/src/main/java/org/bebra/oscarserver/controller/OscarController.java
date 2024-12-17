package org.bebra.oscarserver.controller;

import org.bebra.oscarserver.service.OscarService;
import org.bebra.soacommons.model.soap.GetLoosers;
import org.bebra.soacommons.model.soap.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class OscarController {

    private final String NAMESPACE_URI = "http://www.bebra.org/soacommons/model/soap";

    private final OscarService oscarService;

    @Autowired
    public OscarController(OscarService oscarService) {
        this.oscarService = oscarService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLoosers")
    @ResponsePayload
    public GetLoosers getLoosers() {
        return PersonMapper.mapToGetLoosers(oscarService.getLoosers());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "rewardThriller")
    @ResponsePayload
    public void rewardThriller() {
        oscarService.rewardThriller();
    }
}
