package com.emazon.mscategorias.infrastructure.exceptionhandler;

public enum ExeptionResponse {
    CATEGORY_ALREADY_EXIST("Ya existe esta categoria Digita uno diferente"),
    NAME_CATEGORY_NOT_BLANK("Digita un nombre para tu categoria no puede ir vacio y no puede superar los 50 caracteres"),
    UNAUTHORIZED_USER("NO esta autorizado para crear una categoria"),
    VALID_CATEGORY_DESCRIPTION("No puede superar los 90 caracteres y no puede ir vacio"),
    VALID_PAGE_PARAMETER("Debes digitar Todos los parametros para el paginado"),
    NO_DATA_FOUND_EXCEPTION("No hay Registros en la base de datos");






    private String message;

    ExeptionResponse(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
