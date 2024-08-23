package com.emazon.mscategorias.domain.usecase;

import com.emazon.mscategorias.domain.api_input.ICategoryServicePort;

import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.spi_output.ICategoryPersistancePort;

import com.emazon.mscategorias.infrastructure.exception.NameCategoryNotBlankException;
import com.emazon.mscategorias.infrastructure.exception.UnauthorizedUserException;
import com.emazon.mscategorias.infrastructure.exception.ValidCategoryDescription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryUseCase implements ICategoryServicePort {
    private  final ICategoryPersistancePort categoryPersistancePort;

    public CategoryUseCase(ICategoryPersistancePort categoryPersistancePort) {
        this.categoryPersistancePort = categoryPersistancePort;
    }

    @Override
    public void saveCategory(Category category) {
        String userRol = "ADMIN";
        validAdminUser(userRol);
        validCategoryName(category.getName());
        validCategoryDescription(category.getDescription());

        categoryPersistancePort.saveCategory(category);


    }

    private  void validAdminUser(String rol){
        if(!rol.equals("ADMIN")){
            throw new UnauthorizedUserException();
        }
    }

    private void validCategoryName(String name){
        if(name == null || name.trim().isEmpty() || name.length() > 50){
            throw new NameCategoryNotBlankException();
        }
    }

    private void validCategoryDescription(String description){
        if(description == null || description.trim().isEmpty() || description.length() > 90){
            throw new ValidCategoryDescription();
        }
    }


    @Override
    public List<Category> getAllCategories() {
        return categoryPersistancePort.getAllCategories();
    }

    @Override
    public Category getCategory(Long idCategory) {
        return categoryPersistancePort.getCategory(idCategory);
    }

    @Override
    public void updateCategory(Category category) {
        categoryPersistancePort.updateCategory(category);
    }

    @Override
    public void deleteCategory(Long idCategory) {
        categoryPersistancePort.deleteCategory(idCategory);
    }
}
