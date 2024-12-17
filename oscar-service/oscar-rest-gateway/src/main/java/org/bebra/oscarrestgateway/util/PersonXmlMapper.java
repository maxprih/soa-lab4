package org.bebra.oscarrestgateway.util;

import org.bebra.soacommons.model.dto.PersonDto;
import org.bebra.soacommons.model.soap.PersonMapper;
import org.bebra.soacommons.model.soap.PersonXml;
import org.springframework.stereotype.Component;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

/**
 * @author max_pri
 */
@Component
public class PersonXmlMapper {

    public PersonDto map(PersonXml xml) {
        if (xml == null) {
            return null;
        }

        PersonDto dto = new PersonDto();
        dto.setId(xml.getId());
        dto.setName(xml.getName());
        dto.setHeight(xml.getHeight());
        dto.setWeight(xml.getWeight());
        dto.setPassportId(xml.getPassportId());

        if (xml.getBirthday() != null) {
            dto.setBirthday(xml.getBirthday().toGregorianCalendar().toZonedDateTime().toLocalDate());
        }

        return dto;
    }

    public PersonXml map(PersonDto dto) {
        if (dto == null) {
            return null;
        }

        PersonXml xml = new PersonXml();
        xml.setId(dto.getId());
        xml.setName(dto.getName());
        xml.setHeight(dto.getHeight());
        xml.setWeight(dto.getWeight());
        xml.setPassportId(dto.getPassportId());

        if (dto.getBirthday() != null) {
            xml.setBirthday(toXMLGregorianCalendar(dto.getBirthday()));
        }

        return xml;
    }

    private XMLGregorianCalendar toXMLGregorianCalendar(LocalDate date) {
        try {
            javax.xml.datatype.DatatypeFactory df = javax.xml.datatype.DatatypeFactory.newInstance();
            return df.newXMLGregorianCalendar(date.toString());
        } catch (Exception e) {
            throw new RuntimeException("Error converting LocalDate to XMLGregorianCalendar", e);
        }
    }
}
