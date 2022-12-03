package com.edsontelesfontes.Course.controller.exceptions;

import com.edsontelesfontes.Course.services.exceptions.DatabaseException;
import com.edsontelesfontes.Course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.crypto.Data;
import java.time.Instant;

@ControllerAdvice

public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){

        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError sError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(sError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> dabate(DatabaseException e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError sError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(sError);
    }
}
