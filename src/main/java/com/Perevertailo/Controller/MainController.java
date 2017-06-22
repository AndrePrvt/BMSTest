package com.Perevertailo.Controller;

import com.Perevertailo.Model.DTO.InfoDTO;
import com.Perevertailo.Model.DTO.MessageDTO;
import com.Perevertailo.Service.LogHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by andrey on 18.06.2017.
 */
@RestController

@PropertySource(value = {"classpath:/default.properties"})
public class MainController {

    @Autowired
    LogHandler logHandler;

    private static Logger log = Logger.getLogger(MainController.class.getName());


    @RequestMapping(value = "api/info", method = RequestMethod.GET)
    InfoDTO getCurrentReloadTime(){
        InfoDTO infoDTO = new InfoDTO(logHandler.getCurrentFilePath(), logHandler.getCurrentReloadTime().toString());
        return infoDTO;
    }

    @RequestMapping(value = "api/info", method = RequestMethod.POST)
    String changeTimeReload(@RequestBody InfoDTO infoDTO){
        if (logHandler.changeCurrentReloadTime(Integer.valueOf(infoDTO.getTime()))
                && logHandler.changeCurrentFilePath(infoDTO.getFilePath()))
            return  logHandler.getCurrentReloadTime().toString();
        else
            return "Invalid time";
    }


    @RequestMapping(value = "api/messages", method = RequestMethod.GET, produces = { "application/xml", "text/xml" })
    MessageDTO uploadXML(){
        MessageDTO messageDTO = new MessageDTO();
        log.info("Uploading started");
        try {
            messageDTO = logHandler.uploadResult();
        }catch(IOException e){
            e.printStackTrace();
        }
        return messageDTO;
    }

}
