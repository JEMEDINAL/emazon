package com.emazon.mscategorias.infrastructure.out.jpa.adapter;



import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.domain.model.CustomPageResponse;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.BrandEntity;
import com.emazon.mscategorias.infrastructure.out.jpa.mapper.IBrandEntityMapper;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.IBrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.data.domain.*;

import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class BrandJpaAdapterTest {

    @Mock
    private IBrandRepository brandRepository;

    @Mock
    private IBrandEntityMapper brandEntityMapper;

    @InjectMocks
    private BrandJpaAdapter brandJpaAdapter;

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
       BrandEntity brandEntity = new BrandEntity();
       brandEntity.setName("Test brand");
       List<BrandEntity> brandEntityList = Collections.singletonList(brandEntity);
       Page<BrandEntity> brandEntityPage =new PageImpl<>(brandEntityList,pageable, brandEntityList.size());
       when(brandRepository.findAll(pageable)).thenReturn(brandEntityPage);
       when(brandEntityMapper.toListBrand(brandEntityList)).thenReturn(List.of(new Brand(1l,"nike","la mejor")));
       CustomPageResponse<Brand> response = brandJpaAdapter.getParameterizedBrands(page,size,orden);

       assertNotNull(response);
       assertEquals(1,response.getTotalElements());
       assertEquals(1,response.getTotalPages());
       assertEquals(1,response.getTotalElements());
       assertEquals("nike" , response.getContent().get(0).getName());

       verify(brandRepository).findAll(pageable);

    }
}