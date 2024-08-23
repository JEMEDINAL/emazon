package com.emazon.mscategorias.domain.api_input;

import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.model.Brand;

import java.util.List;

public interface IBrandServicePort {
    Brand saveBrand(Brand brand);

    List<Brand> getAllBrand();

    Brand getBrand(Long idBrand);

    void updateBrand(Brand brand);

    void deleteBrand(Long idBrand);
}
