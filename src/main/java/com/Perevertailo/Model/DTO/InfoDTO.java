package com.Perevertailo.Model.DTO;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by andrey on 20.06.2017.
 */

public class InfoDTO {

    @JsonView
    String filePath;
    @JsonView
    String time;

    public InfoDTO(){

    }

    public InfoDTO(String filePath, String time) {
        this.filePath = filePath;
        this.time = time;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

