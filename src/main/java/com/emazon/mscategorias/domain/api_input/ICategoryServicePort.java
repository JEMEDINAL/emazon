package com.emazon.mscategorias.domain.api_input;

import com.emazon.mscategorias.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {
    void saveCategory(Category category);

    List<Category> getAllCategories();

    Category getCategory(Long idCategory);

    void updateCategory(Category category);

    void deleteCategory(Long idCategory);
}
