package com.tms.exceptions;
 
import java.time.LocalDateTime;
 
public class ExceptionInformation {
 
    private String exceptionMessage;
    private LocalDateTime timestamp;
    private Integer exceptionCode;

    public String getExceptionMessage() {
        return exceptionMessage;
    }
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public Integer getExceptionCode() {
        return exceptionCode;
    }
    public void setExceptionCode(Integer exceptionCode) {
        this.exceptionCode = exceptionCode;
    }    

}