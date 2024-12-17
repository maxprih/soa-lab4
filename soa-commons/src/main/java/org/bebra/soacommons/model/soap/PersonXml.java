package org.bebra.soacommons.model.soap;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personXml", propOrder = {
        "id",
        "name",
        "birthday",
        "height",
        "weight",
        "passportId"
})
@Getter
@Setter
public class PersonXml {
    protected Long id;
    protected String name;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthday;
    protected Double height;
    protected long weight;
    protected String passportId;
}
