package com.cegeka.secretImage.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import java.util.Date;

/**
 * Created by wouterba on 17/02/2017.
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<String> validationErrorHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> unsupportedOperationHandler(UnsupportedOperationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
