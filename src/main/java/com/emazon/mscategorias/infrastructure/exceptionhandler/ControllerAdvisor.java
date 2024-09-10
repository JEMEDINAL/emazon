package com.emazon.mscategorias.infrastructure.exceptionhandler;

import com.emazon.mscategorias.infrastructure.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    private static final String MESSAGE = "Message";

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handlerCategoryAlreadyExistsException(
        CategoryAlreadyExistsException categoryAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExeptionResponse.CATEGORY_ALREADY_EXIST.getMessage()));
    }


    @ExceptionHandler(NameCategoryNotBlankException.class)
    public ResponseEntity<Map<String,String>> nameNotBlank(NameCategoryNotBlankException nameCategoryNotBlankException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExeptionResponse.NAME_CATEGORY_NOT_BLANK.getMessage()));


    }
    @ExceptionHandler(UnauthorizedUserException.class)
    public ResponseEntity<Map<String,String>> unauthorizedUserException(UnauthorizedUserException unauthorizedUserException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExeptionResponse.UNAUTHORIZED_USER.getMessage()));
    }
    @ExceptionHandler(ValidCategoryDescription.class)
    public ResponseEntity<Map<String,String>> validCategoryDescription(ValidCategoryDescription validCategoryDescription){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExeptionResponse.VALID_CATEGORY_DESCRIPTION.getMessage()));
    }


    @ExceptionHandler(ValidPageParameter.class)
    public ResponseEntity<Map<String,String>> validPageParameter(ValidPageParameter validPageParameter){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExeptionResponse.VALID_PAGE_PARAMETER.getMessage()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String,String>> noDataFoundException(NoDataFoundException noDataFoundException){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExeptionResponse.NO_DATA_FOUND_EXCEPTION.getMessage()));
    }
}
