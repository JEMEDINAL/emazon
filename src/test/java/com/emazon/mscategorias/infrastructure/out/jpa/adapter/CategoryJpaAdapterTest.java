package com.emazon.mscategorias.infrastructure.out.jpa.adapter;

import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.model.CustomPageResponse;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.CategoryEntiy;
import com.emazon.mscategorias.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;

import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CategoryJpaAdapterTest {

    @Mock
    private ICategoryRepository iCategoryRepository;

    @Mock
    private CategoryEntityMapper categoryEntityMapper;

    @InjectMocks
    private CategoryJpaAdapter categoryJpaAdapter;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetParameterizedBrand_Success(){
        Integer page = 0;
        Integer size  = 10;
        String orden = "ASC";
        Sort sort = Sort.by(Sort.Direction.fromString(orden),"name");
        Pageable pageable = PageRequest.of(page,size,sort);
        CategoryEntiy categoryEntiy = new CategoryEntiy();
        categoryEntiy.setName("Test brand");
        List<CategoryEntiy> categoryEntiyList = Collections.singletonList(categoryEntiy);
        Page<CategoryEntiy> categoryEntiyPage =new PageImpl<>(categoryEntiyList,pageable, categoryEntiyList.size());
        when(iCategoryRepository.findAll(pageable)).thenReturn(categoryEntiyPage);
        when(categoryEntityMapper.toListCategory(categoryEntiyList)).thenReturn(List.of(new Category(1l,"nike","la mejor")));
        CustomPageResponse<Category> response = categoryJpaAdapter.getParameterizedCategories(page,size,orden);

        assertNotNull(response);
        assertEquals(1,response.getTotalElements());
        assertEquals(1,response.getTotalPages());
        assertEquals(1,response.getTotalElements());
        assertEquals("nike" , response.getContent().get(0).getName());

        verify(iCategoryRepository).findAll(pageable);
    }

}