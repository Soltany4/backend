package com.school.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SchoolUtil {
    
    public SchoolUtil(){}

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<>("{\"message\":\""+responseMessage+"\"}", httpStatus);
        
    }
}
