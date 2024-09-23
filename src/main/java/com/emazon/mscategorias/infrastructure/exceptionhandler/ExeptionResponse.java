package com.emazon.mscategorias.infrastructure.exceptionhandler;

public enum ExeptionResponse {
    CATEGORY_ALREADY_EXIST("Ya existe este nombre Digita uno diferente"),
    NAME_CATEGORY_NOT_BLANK("Digita un nombre no puede ir vacio y no puede superar los 50 caracteres"),
    UNAUTHORIZED_USER("NO esta autorizado "),
    VALID_CATEGORY_DESCRIPTION("La descripcion No puede superar los 90 caracteres y no puede ir vacio"),
    VALID_PAGE_PARAMETER("Debes digitar Todos los parametros para el paginado"),
    NO_DATA_FOUND_EXCEPTION("No hay Registros en la base de datos"),
    VALID_QUANTITY("No puede ir vacio y no puede ser un valor negativo"),
    VALID_PRICE("No puede ir vacio Y no puede ser un valor negativo"),
    VALID_CATEGORIES("No puede ser mas de tres categorias y al menos debe estar relacionada con una categoria"),
    NO_EXIST_CATEGORY("No existe estas categorias");






    private String message;

    ExeptionResponse(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
