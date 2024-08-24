package com.emazon.mscategorias.infrastructure.out.jpa.adapter;

import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.spi_output.ICategoryPersistancePort;
import com.emazon.mscategorias.infrastructure.exception.CategoryAlreadyExistsException;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.CategoryEntiy;
import com.emazon.mscategorias.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter  implements ICategoryPersistancePort {
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    @Override
    public void saveCategory(Category category) {

        if(categoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExistsException();
        }
        CategoryEntiy categoryEntiy = categoryEntityMapper.toEntity(category);


        categoryRepository.save(categoryEntiy);
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public List<Category> getParameterizedCategories(int page, int size, String orden) {
        Sort sort = Sort.by(Sort.Direction.fromString(orden),"name");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<CategoryEntiy> categoryEntiyPage = categoryRepository.findAll(pageable);
        return categoryEntityMapper.toListCategory(categoryEntiyPage.getContent());
    }

    @Override
    public Category getCategory(Long idCategory) {
        return null;
    }

    @Override
    public void updateCategory(Category category) {

    }

    @Override
    public void deleteCategory(Long idCategory) {

    }
}
