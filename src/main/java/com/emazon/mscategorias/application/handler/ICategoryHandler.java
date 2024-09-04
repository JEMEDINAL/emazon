package com.emazon.mscategorias.application.handler;

import com.emazon.mscategorias.application.dto.CategoryRequestDto;
import com.emazon.mscategorias.application.dto.CategoryResponseDto;
import com.emazon.mscategorias.domain.model.CustomPageResponse;



public interface ICategoryHandler {
    void saveCategoryInCategoriesDb(CategoryRequestDto categoryRequestDto);



    CustomPageResponse<CategoryResponseDto> getParameterizedCategories(int page, int size, String orden);


}
