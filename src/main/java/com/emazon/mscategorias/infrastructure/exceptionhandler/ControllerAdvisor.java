package com.emazon.mscategorias.infrastructure.exceptionhandler;

import com.emazon.mscategorias.infrastructure.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(ValidQuantity.class)
    public ResponseEntity<Map<String,String>> validQuantity(ValidQuantity validQuantity){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExeptionResponse.VALID_QUANTITY.getMessage()));
    }

    @ExceptionHandler(ValidPrice.class)
    public ResponseEntity<Map<String,String>> validPrice(ValidPrice validPrice){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExeptionResponse.VALID_PRICE.getMessage()));
    }

    @ExceptionHandler(ValidIdsCategories.class)
    public ResponseEntity<Map<String,String>> validIdsCategories(ValidIdsCategories validIdsCategories){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExeptionResponse.VALID_CATEGORIES.getMessage()));
    }

    @ExceptionHandler(NoExistCategories.class)
    public ResponseEntity<Map<String,String>> noExistCategories(NoExistCategories noExistCategories){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE,ExeptionResponse.NO_EXIST_CATEGORY.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        String errorMessage = (fieldError != null) ? fieldError.getDefaultMessage() : "Error de validación";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap("message", errorMessage));
    }
}
