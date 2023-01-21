package com.ms.hireme.utils.exceptionsHandler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.hireme.utils.exceptions.DataBaseException;
import com.ms.hireme.utils.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException error, HttpServletRequest request){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(httpStatus.value());
        err.setError("Resource not found");
        err.setMessage(error.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> entityNotFound(DataBaseException error, HttpServletRequest request){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(httpStatus.value());
        err.setError("Database exception");
        err.setMessage(error.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(err);
    }
}
