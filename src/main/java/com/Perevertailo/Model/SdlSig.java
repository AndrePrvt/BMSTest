package com.Perevertailo.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "SdlSig")
public class SdlSig {

    String id;
    String time;
    String message_type;
    String timer;
    String condition;
    String additionalPropertyN1;
    String additionalPropertyN2;
    String additionalPropertyN3;
    String additionalPropertyN4;



    public String getId() {
        return id;
    }

    @XmlElement
    public void setId(String id) {
        this.id = id;
    }


    public String getTime() {
        return time;
    }
    @XmlElement
    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage_type() {
        return message_type;
    }
    @XmlElement
    public void setMessage_type(String message_type) {
        this.message_type = message_type;
    }

    public String getTimer() {
        return timer;
    }
    @XmlElement
    public void setTimer(String timer) {
        this.timer = timer;
    }

    public String getCondition() {
        return condition;
    }
    @XmlElement
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAdditionalPropertyN1() {
        return additionalPropertyN1;
    }
    @XmlElement
    public void setAdditionalPropertyN1(String additionalPropertyN1) {
        this.additionalPropertyN1 = additionalPropertyN1;
    }

    public String getAdditionalPropertyN2() {
        return additionalPropertyN2;
    }
    @XmlElement
    public void setAdditionalPropertyN2(String additionalPropertyN2) {
        this.additionalPropertyN2 = additionalPropertyN2;
    }

    public String getAdditionalPropertyN3() {
        return additionalPropertyN3;
    }
    @XmlElement
    public void setAdditionalPropertyN3(String additionalPropertyN3) {
        this.additionalPropertyN3 = additionalPropertyN3;
    }

    public String getAdditionalPropertyN4() {
        return additionalPropertyN4;
    }
    @XmlElement
    public void setAdditionalPropertyN4(String additionalPropertyN4) {
        this.additionalPropertyN4 = additionalPropertyN4;
    }

}
