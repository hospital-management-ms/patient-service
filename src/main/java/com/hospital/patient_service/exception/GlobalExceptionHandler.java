package com.hospital.patient_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){

        Map<String, String> err= new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> err.put(error.getField(),error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(err);
    }

}
