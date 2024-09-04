package com.emazon.mscategorias.infrastructure.out.jpa.mapper;


import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.BrandEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IBrandEntityMapper {

    BrandEntity toEntity(Brand brand);

}
