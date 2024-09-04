package com.emazon.mscategorias.application.mapper;

import com.emazon.mscategorias.application.dto.BrandRequestDto;

import com.emazon.mscategorias.domain.model.Brand;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandRequestMapper {
    Brand toBrand(BrandRequestDto brandRequestDto);
}
