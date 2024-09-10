package com.emazon.mscategorias.domain.spi_output;

import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.model.CustomPageResponse;



public interface ICategoryPersistancePort {
    void saveCategory(Category category);



    CustomPageResponse<Category> getParameterizedCategories(int page, int size, String orden);


}
