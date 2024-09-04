package com.emazon.mscategorias.domain.usecase;

import com.emazon.mscategorias.domain.api_input.ICategoryServicePort;

import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.model.CustomPageResponse;
import com.emazon.mscategorias.domain.spi_output.ICategoryPersistancePort;

import com.emazon.mscategorias.infrastructure.exception.NameNotBlankException;
import com.emazon.mscategorias.infrastructure.exception.UnauthorizedUserException;
import com.emazon.mscategorias.infrastructure.exception.ValidDescription;
import org.springframework.stereotype.Service;

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

        if(category.getName() == null || category.getName().trim().isEmpty() || category.getName().length() >= 50){
            throw new NameNotBlankException();
        }

        if(category.getDescription() == null ||  category.getDescription().trim().isEmpty() || category.getDescription().length() > 90){
            throw new ValidDescription();
        }

        categoryPersistancePort.saveCategory(category);

    }


    private  void validAdminUser(String rol){
        if(!rol.equals("ADMIN")){
            throw new UnauthorizedUserException();
        }
    }


    @Override
    public CustomPageResponse<Category> getParameterizedCategories(int page, int size, String orden) {
        return categoryPersistancePort.getParameterizedCategories(page, size, orden);
    }



}
