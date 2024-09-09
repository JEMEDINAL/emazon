package com.emazon.mscategorias.domain.api_input;


import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.domain.model.CustomPageResponse;



public interface IBrandServicePort {

    void saveBrand(Brand brand);

    CustomPageResponse<Brand> getParameterizedBrands(Integer page, Integer size, String orden);

}
