package com.autoparts.cartservice.controllers;


import com.autoparts.cartservice.core.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundException> handleNotFoundException(ResourceNotFoundException e){
        return ResponseEntity.status(404).body(e);
    }

    @ExceptionHandler(InsufficientQuantityException.class)
    public ResponseEntity<InsufficientQuantityException> handleInsufficientQuantityException(InsufficientQuantityException e){
        return ResponseEntity.status(400).body(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MultipleErrorResponse> handleNoValidException(MethodArgumentNotValidException e){
        MultipleErrorResponse errorResponse = new MultipleErrorResponse("Validation error");
        e.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> errorResponse.add(new ErrorField(fieldError.getField(),
                        fieldError.getDefaultMessage())));
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> handleOtherException(Throwable e){
        return ResponseEntity.status(500).body(e.getMessage());
    }
}
