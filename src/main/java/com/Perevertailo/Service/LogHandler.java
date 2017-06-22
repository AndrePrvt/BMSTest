package com.Perevertailo.Service;

import com.Perevertailo.Model.DTO.MessageDTO;
import com.Perevertailo.Model.SdlSig;
import com.Perevertailo.Model.Stopping;

import java.io.IOException;
import java.util.List;


public interface LogHandler {

    Integer getCurrentReloadTime();
    boolean changeCurrentReloadTime(int time);
    String getCurrentFilePath();
    boolean changeCurrentFilePath(String filePath);
    MessageDTO uploadResult() throws IOException;

}
