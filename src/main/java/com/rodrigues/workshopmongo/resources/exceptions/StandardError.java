package com.rodrigues.workshopmongo.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private Long timeStamp;
    private String message, path, error;
    private Integer status;

    public StandardError(Long timeStamp, String message, String path, String error, Integer status) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.path = path;
        this.error = error;
        this.status = status;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
