package org.bebra.oscarrestgateway.service;

import lombok.RequiredArgsConstructor;
import org.bebra.oscarrestgateway.web.OscarClient;
import org.bebra.soacommons.model.dto.MovieDto;
import org.bebra.soacommons.model.dto.PersonDto;
import org.bebra.soacommons.model.enums.MovieGenre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OscarService {
    private final OscarClient oscarClient;

    public List<PersonDto> getLoosers() {
        return oscarClient.getLoosers();
    }

    public void rewardThriller() {
        oscarClient.rewardThriller();
    }
}
