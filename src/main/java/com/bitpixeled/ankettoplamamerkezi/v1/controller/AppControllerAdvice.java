package com.bitpixeled.ankettoplamamerkezi.v1.controller;

import com.bitpixeled.ankettoplamamerkezi.v1.exception.IdDidNotMatch;
import com.bitpixeled.ankettoplamamerkezi.v1.exception.RecordNotFound;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(value = RecordNotFound.class)
    public String handleRecordNotFound(RecordNotFound ex){
        return ex.getMessage();
    }

    @ExceptionHandler(value = IdDidNotMatch.class)
    public String handleIdDidNotMatch(IdDidNotMatch ex){
        return "Path de verilen Id: "+ex.getPathId()+" Obje Id "+ex.getEntityId()+" uyuşmamaktadır";
    }
}
