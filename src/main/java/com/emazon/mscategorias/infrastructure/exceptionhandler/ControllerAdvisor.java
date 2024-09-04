package com.emazon.mscategorias.infrastructure.exceptionhandler;

import com.emazon.mscategorias.infrastructure.exception.AlreadyExistsException;
import com.emazon.mscategorias.infrastructure.exception.NameNotBlankException;
import com.emazon.mscategorias.infrastructure.exception.UnauthorizedUserException;
import com.emazon.mscategorias.infrastructure.exception.ValidDescription;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    private static final String MESSAGE = "Message";

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handlerCategoryAlreadyExistsException(
        AlreadyExistsException alreadyExistsException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExeptionResponse.CATEGORY_ALREADY_EXIST.getMessage()));
    }


    @ExceptionHandler(NameNotBlankException.class)
    public ResponseEntity<Map<String,String>> nameNotBlank(NameNotBlankException nameNotBlankException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExeptionResponse.NAME_CATEGORY_NOT_BLANK.getMessage()));


    }
    @ExceptionHandler(UnauthorizedUserException.class)
    public ResponseEntity<Map<String,String>> unauthorizedUserException(UnauthorizedUserException unauthorizedUserException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExeptionResponse.UNAUTHORIZED_USER.getMessage()));
    }
    @ExceptionHandler(ValidDescription.class)
    public ResponseEntity<Map<String,String>> validCategoryDescription(ValidDescription validDescription){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExeptionResponse.VALID_CATEGORY_DESCRIPTION.getMessage()));
    }
}
