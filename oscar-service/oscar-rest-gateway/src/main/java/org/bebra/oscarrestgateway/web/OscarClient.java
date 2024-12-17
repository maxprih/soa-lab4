package org.bebra.oscarrestgateway.web;

import lombok.Setter;
import org.bebra.oscarrestgateway.util.PersonXmlMapper;
import org.bebra.soacommons.model.dto.PersonDto;
import org.bebra.soacommons.model.soap.GetLoosers;
import org.bebra.soacommons.model.soap.RewardThriller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author max_pri
 */
public class OscarClient extends WebServiceGatewaySupport {

    @Setter
    private PersonXmlMapper mapper;

    public List<PersonDto> getLoosers() {
        GetLoosers request = new GetLoosers();
        GetLoosers response = (GetLoosers) getWebServiceTemplate().marshalSendAndReceive(request);

        return response.getLoosers().stream().map(mapper::map).collect(Collectors.toList());
    }

    public void rewardThriller() {
        getWebServiceTemplate().marshalSendAndReceive(new RewardThriller());
    }
}
