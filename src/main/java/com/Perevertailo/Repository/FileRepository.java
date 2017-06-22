package com.Perevertailo.Repository;

import com.Perevertailo.Model.DTO.MessageDTO;

import java.io.IOError;
import java.io.IOException;

/**
 * Created by andrey on 18.06.2017.
 */
public interface FileRepository {

    public int getTime();

    public void setTime(int time);

    public String getPath();

    public void setPath(String path);

    public MessageDTO getXMLMessages() throws IOException;
}
