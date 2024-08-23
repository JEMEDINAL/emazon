package com.emazon.mscategorias.domain.spi_output;

import com.emazon.mscategorias.domain.model.Category;

import java.util.List;

public interface ICategoryPersistancePort {
    void saveCategory(Category category);

    List<Category> getAllCategories();

    Category getCategory(Long idCategory);

    void updateCategory(Category category);

    void deleteCategory(Long idCategory);
}
