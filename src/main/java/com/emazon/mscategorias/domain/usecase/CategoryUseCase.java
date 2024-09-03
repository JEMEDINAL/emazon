package com.emazon.mscategorias.domain.usecase;

import com.emazon.mscategorias.domain.api_input.ICategoryServicePort;

import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.spi_output.ICategoryPersistancePort;

import com.emazon.mscategorias.infrastructure.exception.NameCategoryNotBlankException;
import com.emazon.mscategorias.infrastructure.exception.UnauthorizedUserException;
import com.emazon.mscategorias.infrastructure.exception.ValidCategoryDescription;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
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

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    private  void validAdminUser(String rol){
        if(!rol.equals("ADMIN")){
            throw new UnauthorizedUserException();
        }
    }

    private void validCategoryName(String name){
        if(name == null || name.trim().isEmpty() || name.length() >= 50){
            throw new NameCategoryNotBlankException();
        }
    }

    private void validCategoryDescription(String description){
        if(description == null || description.trim().isEmpty() || description.length() > 90){
            throw new ValidCategoryDescription();
        }
    }



    @Override
    public List<Category> getParameterizedCategories(int page, int size,String orden) {
        return categoryPersistancePort.getParameterizedCategories(page, size, orden);
    }



}
