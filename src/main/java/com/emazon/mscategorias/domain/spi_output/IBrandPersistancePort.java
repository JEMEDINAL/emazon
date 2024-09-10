package com.emazon.mscategorias.domain.spi_output;

import com.emazon.mscategorias.domain.model.Brand;

import com.emazon.mscategorias.domain.model.CustomPageResponse;


public interface IBrandPersistancePort {
    void saveBrand(Brand brand);

    CustomPageResponse<Brand> getParameterizedBrands(Integer page, Integer size, String orden);

}
