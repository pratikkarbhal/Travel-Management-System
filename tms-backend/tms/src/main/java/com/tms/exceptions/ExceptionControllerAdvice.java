package com.tms.exceptions;

import java.time.LocalDateTime;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
 
@RestControllerAdvice
public class ExceptionControllerAdvice {
 
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionInformation> exceptionHandler(Exception exception){
        ExceptionInformation info=new ExceptionInformation();
        info.setExceptionMessage(exception.getMessage());
        info.setTimestamp(LocalDateTime.now());
        info.setExceptionCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<ExceptionInformation>(info,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionInformation> exceptionHandler(MethodArgumentNotValidException exception){
        ExceptionInformation info=new ExceptionInformation();
        //info.setExceptionMessage(exception.getBindingResult().getAllErrors().toString());
        info.setExceptionMessage("validation failed");
        info.setTimestamp(LocalDateTime.now());
        info.setExceptionCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ExceptionInformation>(info,HttpStatus.NOT_FOUND);
    }

}