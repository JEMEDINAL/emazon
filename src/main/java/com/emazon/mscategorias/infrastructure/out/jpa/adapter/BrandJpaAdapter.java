package com.emazon.mscategorias.infrastructure.out.jpa.adapter;

import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.domain.spi_output.IBrandPersistancePort;
import com.emazon.mscategorias.infrastructure.exception.AlreadyExistsException;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.BrandEntity;
import com.emazon.mscategorias.infrastructure.out.jpa.mapper.IBrandEntityMapper;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrandJpaAdapter implements IBrandPersistancePort{
    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;

    @Override
    public void saveBrand(Brand brand) {

        if(brandRepository.findByName(brand.getName()).isPresent()){
            throw new AlreadyExistsException();
        }
        BrandEntity brandEntity = brandEntityMapper.toEntity(brand);

        brandRepository.save(brandEntity);
    }
}
