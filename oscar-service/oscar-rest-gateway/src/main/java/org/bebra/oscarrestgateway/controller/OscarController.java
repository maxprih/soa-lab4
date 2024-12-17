package org.bebra.oscarrestgateway.controller;

import org.bebra.oscarrestgateway.service.OscarService;
import org.bebra.soacommons.model.dto.PersonDto;
import org.bebra.soacommons.model.soap.GetLoosers;
import org.bebra.soacommons.model.soap.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;


@RestController
@RequestMapping("/api/v1/oscar")
public class OscarController {

    private final OscarService oscarService;

    @Autowired
    public OscarController(OscarService oscarService) {
        this.oscarService = oscarService;
    }

    @GetMapping("/directors/get-loosers")
    public ResponseEntity<List<PersonDto>> getLoosers() {
        return ResponseEntity.ok(oscarService.getLoosers());
    }

    @PostMapping("/movies/reward-thriller")
    public ResponseEntity<Void> rewardThriller() {
        oscarService.rewardThriller();
        return ResponseEntity.ok().build();
    }
}
