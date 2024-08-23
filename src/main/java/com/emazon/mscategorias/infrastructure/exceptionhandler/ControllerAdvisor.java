package com.emazon.mscategorias.infrastructure.exceptionhandler;

import com.emazon.mscategorias.infrastructure.exception.CategoryAlreadyExistsException;
import com.emazon.mscategorias.infrastructure.exception.NameCategoryNotBlankException;
import com.emazon.mscategorias.infrastructure.exception.UnauthorizedUserException;
import com.emazon.mscategorias.infrastructure.exception.ValidCategoryDescription;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
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
}
