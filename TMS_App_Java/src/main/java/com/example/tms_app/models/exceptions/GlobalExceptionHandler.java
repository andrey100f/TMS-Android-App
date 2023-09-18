package com.example.tms_app.models.exceptions;

import com.example.tms_app.models.exceptions.models.EntityNotFoundException;
import com.example.tms_app.models.exceptions.models.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value=EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionModel handleEntityNotFoundException(EntityNotFoundException exception) {
        return new ExceptionModel(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionModel handleGeneralException(Exception exception) {
        return new ExceptionModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }
}
