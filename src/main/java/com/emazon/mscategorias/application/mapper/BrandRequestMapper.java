package com.emazon.mscategorias.application.mapper;

import com.emazon.mscategorias.application.dto.BrandRequestDto;

import com.emazon.mscategorias.application.dto.BrandResponseDto;
import com.emazon.mscategorias.domain.model.Brand;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandRequestMapper {
    Brand toBrand(BrandRequestDto brandRequestDto);

    default List<BrandResponseDto> toResponseList(List<Brand> brandList){
        return brandList.stream()
                .map(brand -> {
                    BrandResponseDto brandResponseDto = new BrandResponseDto();
                    brandResponseDto.setName(brand.getName());
                    brandResponseDto.setDescription(brand.getDescription());
                    return brandResponseDto;
                }).toList();
    }
}
