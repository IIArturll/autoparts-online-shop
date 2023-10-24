package com.autoparts.cartservice.controllers.clients;


import com.autoparts.cartservice.core.exceptions.ErrorField;
import com.autoparts.cartservice.core.exceptions.MultipleErrorResponse;
import com.autoparts.cartservice.core.exceptions.ProductNotFoundException;
import com.autoparts.cartservice.core.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundException> handleNotFoundException(ProductNotFoundException e){
        return ResponseEntity.status(404).body(e);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserNotFoundException> handleNotFoundException(UserNotFoundException e){
        return ResponseEntity.status(404).body(e);
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
