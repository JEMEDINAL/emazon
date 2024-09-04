package com.emazon.mscategorias.domain.api_input;

import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.model.CustomPageResponse;



public interface ICategoryServicePort {
    void saveCategory(Category category);



    CustomPageResponse<Category> getParameterizedCategories(int page, int size, String orden);


}
