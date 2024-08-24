package com.emazon.mscategorias.application.handler;

import com.emazon.mscategorias.application.dto.CategoryRequestDto;
import com.emazon.mscategorias.application.dto.CategoryResponseDto;
import com.emazon.mscategorias.application.mapper.CategoryRequestMapper;
import com.emazon.mscategorias.domain.api_input.ICategoryServicePort;
import com.emazon.mscategorias.domain.model.Category;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler{
    @Qualifier("categoryServicePort")
    private final ICategoryServicePort iCategoryServicePort;
    private final CategoryRequestMapper categoryRequestMapper;


    @Override
    public void saveCategoryInCategoriesDb(CategoryRequestDto categoryRequestDto) {
        Category category = categoryRequestMapper.toCategory(categoryRequestDto);
        iCategoryServicePort.saveCategory(category);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return List.of();
    }

    @Override
    public List<CategoryResponseDto> getParameterizedCategories(int page, int size, String orden) {
        return categoryRequestMapper.toResponseList(iCategoryServicePort.getParameterizedCategories(page,size,orden));
    }

}
