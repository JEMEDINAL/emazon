package com.emazon.mscategorias.domain.spi_output;

import com.emazon.mscategorias.domain.model.Brand;

import java.util.List;

public interface IBrandPersistancePort {
    void saveBrand(Brand brand);

    List<Brand> getAllBrand();

    Brand getBrand(Long idBrand);

    void updateBrand(Brand brand);

    void deleteBrand(Long idBrand);
}
