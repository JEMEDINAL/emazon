package com.emazon.mscategorias.infrastructure.exceptionhandler;

public enum ExeptionResponse {
    CATEGORY_ALREADY_EXIST("Ya existe este nombre Digita uno diferente"),
    NAME_CATEGORY_NOT_BLANK("Digita un nombre no puede ir vacio y no puede superar los 50 caracteres"),
    UNAUTHORIZED_USER("NO esta autorizado "),
    VALID_CATEGORY_DESCRIPTION("La descripcion No puede superar los 90 caracteres y no puede ir vacio");





    private String message;

    ExeptionResponse(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
