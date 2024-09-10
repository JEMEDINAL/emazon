package com.emazon.mscategorias.infrastructure.out.jpa.adapter;

import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.domain.model.CustomPageResponse;
import com.emazon.mscategorias.domain.spi_output.IBrandPersistancePort;
import com.emazon.mscategorias.infrastructure.exception.AlreadyExistsException;
import com.emazon.mscategorias.infrastructure.exception.NoDataFoundException;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.BrandEntity;
import com.emazon.mscategorias.infrastructure.out.jpa.mapper.IBrandEntityMapper;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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

    @Override
    public CustomPageResponse<Brand> getParameterizedBrands(Integer page, Integer size, String orden) {
        Sort sort = Sort.by(Sort.Direction.fromString(orden),"name");
        Pageable pegeable = PageRequest.of(page,size,sort);
        Page<BrandEntity> brandEntityPage = brandRepository.findAll(pegeable);
        if(brandEntityPage.getTotalElements() == 0){
            throw new NoDataFoundException();
        }
        List<Brand> brandList = brandEntityMapper.toListBrand(brandEntityPage.getContent());
        
        return new CustomPageResponse<>(brandList,
                brandEntityPage.getNumber(),
                brandEntityPage.getSize(),
                brandEntityPage.getTotalElements(),
                brandEntityPage.getTotalPages(),
                orden
        );
    }
}
