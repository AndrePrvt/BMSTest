package com.Perevertailo.Model.DTO;

import com.Perevertailo.Model.SdlSig;
import com.Perevertailo.Model.Stopping;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by andrey on 18.06.2017.
 */

@XmlRootElement
public class MessageDTO {

    @XmlElement
    String header ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>";

    List<SdlSig> sdlSigsMessages;
    List<Stopping> stoppingMessages;

    public List<SdlSig> getSdlSigsMessages() {
        return sdlSigsMessages;
    }

    @XmlElement
    public void setSdlSigsMessages(List<SdlSig> sdlSigsMessages) {
        this.sdlSigsMessages = sdlSigsMessages;
    }
    public List<Stopping> getStoppingMessages() {
        return stoppingMessages;
    }

    @XmlElement
    public void setStoppingMessages(List<Stopping> stoppingMessages) {
        this.stoppingMessages = stoppingMessages;
    }
}
