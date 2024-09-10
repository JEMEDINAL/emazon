package com.emazon.mscategorias.application.handler;

import com.emazon.mscategorias.application.dto.BrandRequestDto;
import com.emazon.mscategorias.application.dto.BrandResponseDto;
import com.emazon.mscategorias.application.mapper.BrandRequestMapper;
import com.emazon.mscategorias.domain.api_input.IBrandServicePort;
import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.domain.model.CustomPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandHandler implements IBrandHandler{

    private final IBrandServicePort iBrandServicePort;
    private final BrandRequestMapper brandRequestMapper;
    @Override
    public void saveBrandInBrandsDb(BrandRequestDto brandRequestDto) {
        Brand brand = brandRequestMapper.toBrand(brandRequestDto);
        iBrandServicePort.saveBrand(brand);

    }

    @Override
    public CustomPageResponse<BrandResponseDto> getParameterizedCategories(Integer page, Integer size, String orden) {
        CustomPageResponse<Brand> pageCustom = iBrandServicePort.getParameterizedBrands(page, size, orden);
        List<BrandResponseDto> brandResponseDtos = brandRequestMapper.toResponseList(pageCustom.getContent());

        return new CustomPageResponse<>(brandResponseDtos,pageCustom.getPage(),
                pageCustom.getSize(),pageCustom.getTotalElements(),pageCustom.getTotalPages(), pageCustom.getOrden());
    }
}
