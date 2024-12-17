package org.bebra.soacommons.model.soap;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {
    }

    public GetLoosers createGetLoosers() {
        return new GetLoosers();
    }

    public PersonXml createPersonXml() {
        return new PersonXml();
    }

    public RewardThriller createRewardThriller() {
        return new RewardThriller();
    }
}