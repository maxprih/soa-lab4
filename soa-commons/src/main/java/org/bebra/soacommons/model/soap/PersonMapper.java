package org.bebra.soacommons.model.soap;

import org.bebra.soacommons.model.dto.PersonDto;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class PersonMapper {

    public static GetLoosers mapToGetLoosers(List<PersonDto> personDtoList) {
        GetLoosers getLoosers = new GetLoosers();
        List<PersonXml> personXmlList = personDtoList.stream()
                .map(PersonMapper::mapToPersonXml)
                .collect(Collectors.toList());
        getLoosers.setLoosers(personXmlList);
        return getLoosers;
    }

    private static PersonXml mapToPersonXml(PersonDto dto) {
        PersonXml personXml = new PersonXml();
        personXml.setId(dto.getId());
        personXml.setName(dto.getName());
        personXml.setBirthday(toXMLGregorianCalendar(dto.getBirthday()));
        personXml.setHeight(dto.getHeight());
        personXml.setWeight(dto.getWeight());
        personXml.setPassportId(dto.getPassportId());
        return personXml;
    }

    private static XMLGregorianCalendar toXMLGregorianCalendar(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        try {
            GregorianCalendar gregorianCalendar = GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException("Error converting LocalDate to XMLGregorianCalendar", e);
        }
    }
}
