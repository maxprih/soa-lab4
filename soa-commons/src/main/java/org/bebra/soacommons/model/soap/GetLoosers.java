package org.bebra.soacommons.model.soap;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "loosers"
})
@XmlRootElement(name = "getLoosers")
@Getter
@Setter
public class GetLoosers {
    @XmlElement(nillable = true)
    protected List<PersonXml> loosers;
}