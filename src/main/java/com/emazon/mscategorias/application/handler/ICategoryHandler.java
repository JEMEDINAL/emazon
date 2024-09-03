package com.emazon.mscategorias.application.handler;

import com.emazon.mscategorias.application.dto.CategoryRequestDto;
import com.emazon.mscategorias.application.dto.CategoryResponseDto;

import java.util.List;

public interface ICategoryHandler {
    void saveCategoryInCategoriesDb(CategoryRequestDto categoryRequestDto);

    List<CategoryResponseDto> getAllCategories();

    List<CategoryResponseDto> getParameterizedCategories(int page, int size,String orden);


}
