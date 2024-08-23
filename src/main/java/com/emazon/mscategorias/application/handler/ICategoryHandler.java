package com.emazon.mscategorias.application.handler;

import com.emazon.mscategorias.application.dto.CategoryRequestDto;

public interface ICategoryHandler {
    void saveCategoryInCategoriesDb(CategoryRequestDto categoryRequestDto);
}
