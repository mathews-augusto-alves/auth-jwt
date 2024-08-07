package com.test.infrastructure.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ResponseHandler {

    protected record Response(
            Object data,
            List<String> errors,
            Integer code,
            LocalDateTime dateTime,
            String message
            ) {}

    public ResponseEntity<Response> generateResponseWithDTO(String message, HttpStatus status, Object responseObj) {
        Response response = new Response(
            responseObj, 
            new ArrayList<>(), 
            status.value(), 
            LocalDateTime.now(), 
            message);

        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<Response> generateResponseSuccess(Object response) {
        return generateResponseWithDTO("Success.", HttpStatus.OK, response);
    }

    public ResponseEntity<Response> generateResponseInvalidModelState(BindingResult result, String message) {
      
       Response response = new Response(
            null, 
            result.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList()), 
            HttpStatus.BAD_REQUEST.value(), 
            LocalDateTime.now(), 
            message);


        return ResponseEntity.badRequest().body(response);
    }
}
