package com.Perevertailo.Service;

import com.Perevertailo.Model.DTO.MessageDTO;
import com.Perevertailo.Repository.FileRepositoryImpl;
import com.Perevertailo.Model.SdlSig;
import com.Perevertailo.Model.Stopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Boris on 15.06.2017.
 */

@Service
public class LogHandlerImpl implements LogHandler {

    @Autowired
    FileRepositoryImpl fileRepository;

    @Override
    public Integer getCurrentReloadTime() {
        return fileRepository.getTime();
    }

    @Override
    public boolean changeCurrentReloadTime(int time) {
        if (time > 0){
            fileRepository.setTime(time);
            return true;
        }
        return false;
    }

    @Override
    public String getCurrentFilePath() {
        return fileRepository.getPath();
    }

    @Override
    public boolean changeCurrentFilePath(String filePath){
        File file = new File(filePath);
        if (file.exists() && file.isFile()){
            fileRepository.setPath(filePath);
            return true;
        }
        return false;
    }

    @Override
    public MessageDTO uploadResult() throws IOException {
        return fileRepository.getXMLMessages();
    }
}