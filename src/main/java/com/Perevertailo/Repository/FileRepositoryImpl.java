package com.Perevertailo.Repository;

import com.Perevertailo.Model.DTO.MessageDTO;
import com.Perevertailo.Model.SdlSig;
import com.Perevertailo.Model.Stopping;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
@PropertySource(value = {"classpath:/default.properties"})
public class FileRepositoryImpl implements FileRepository {

    @Value("${default.path}")
    private String propsPath;
    @Value("${file.path}")
    private String path;
    @Value("${schedule.time}")
    private int time;
    final private String regex = "(.*\\d{8}\\.\\d{3}\\s)\\|(.*)\\|(SdlSig|Stopping).*\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)";



    private String getLogData()throws IOException{
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charset.defaultCharset());
    }

    public MessageDTO getXMLMessages() throws IOException{
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(getLogData());
        ArrayList<SdlSig> sdlSigs = new ArrayList<>();
        ArrayList<Stopping> stoppings = new ArrayList<>();
        while(matcher.find()){
            String [] properties = matcher.group().toString().split("\\|");
            if (properties[2].equals("SdlSig   ")){
                SdlSig sdlSig = new SdlSig();
                sdlSig.setId(properties[0]);
                sdlSig.setTime(properties[1]);
                sdlSig.setMessage_type(properties[2]);
                sdlSig.setTimer(properties[3]);
                sdlSig.setCondition(properties[4]);
                sdlSig.setAdditionalPropertyN1(properties[5]);
                sdlSig.setAdditionalPropertyN2(properties[6]);
                sdlSig.setAdditionalPropertyN3(properties[7]);
                sdlSig.setAdditionalPropertyN4(properties[8]);
                sdlSigs.add(sdlSig);
            }else {
                if (properties[2].equals("Stopping ")) {
                    Stopping stopping = new Stopping();
                    stopping.setId(properties[0]);
                    stopping.setTime(properties[1]);
                    stopping.setMessage_type(properties[2]);
                    stopping.setCondition(properties[3]);
                    stopping.setAdditionalPropertyN1(properties[4]);
                    stopping.setAdditionalPropertyN2(properties[5]);
                    stopping.setAdditionalPropertyN3(properties[6]);
                    stopping.setAdditionalPropertyN4(properties[7]);
                    stoppings.add(stopping);
                }
            }
        }
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setSdlSigsMessages(sdlSigs);
        messageDTO.setStoppingMessages(stoppings);
        return messageDTO;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time =time;
        try {
            PropertiesConfiguration config = new PropertiesConfiguration(propsPath);
            config.setProperty("schedule.time", time);
            config.save();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        try {
            PropertiesConfiguration config = new PropertiesConfiguration(propsPath);
            config.setProperty("file.path", path);
            config.save();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
