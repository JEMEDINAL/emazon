package com.emazon.mscategorias.domain.api_input;


import com.emazon.mscategorias.domain.model.Brand;

import java.util.List;

public interface IBrandServicePort {

    void saveBrand(Brand brand);

    List<Brand> getParameterizedBrands(int page,int size,String orden);

}
