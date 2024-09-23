package com.emazon.mscategorias.infrastructure.out.jpa.adapter;

import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.model.CustomPageResponse;
import com.emazon.mscategorias.domain.spi_output.ICategoryPersistancePort;
import com.emazon.mscategorias.infrastructure.exception.AlreadyExistsException;
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
            throw new AlreadyExistsException();
        }
        CategoryEntiy categoryEntiy = categoryEntityMapper.toEntity(category);

        categoryRepository.save(categoryEntiy);
    }



    @Override
    public CustomPageResponse<Category> getParameterizedCategories(int page, int size, String orden) {


        Sort sort = Sort.by(Sort.Direction.fromString(orden),"name");

        Pageable pageable = PageRequest.of(page,size,sort);

        Page<CategoryEntiy> categoryEntiyPage = categoryRepository.findAll(pageable);
        List<Category> categoryList = categoryEntityMapper.toListCategory(categoryEntiyPage.getContent());


        return new CustomPageResponse<>(categoryList,
                categoryEntiyPage.getNumber(),
                categoryEntiyPage.getSize(),
                categoryEntiyPage.getTotalElements(),
                categoryEntiyPage.getTotalPages(),
                orden);
    }


}
