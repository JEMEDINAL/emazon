package com.emazon.mscategorias.infrastructure.out.jpa.mapper;


import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        unmappedSourcePolicy = ReportingPolicy.WARN)
public interface IBrandEntityMapper {

    BrandEntity toEntity(Brand brand);
    List<Brand> toListBrand(List<BrandEntity> brandEntityList);
}
