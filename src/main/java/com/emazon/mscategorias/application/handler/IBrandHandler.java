package com.emazon.mscategorias.application.handler;

import com.emazon.mscategorias.application.dto.BrandRequestDto;
import com.emazon.mscategorias.application.dto.BrandResponseDto;
import com.emazon.mscategorias.domain.model.CustomPageResponse;


public interface IBrandHandler {
    void saveBrandInBrandsDb(BrandRequestDto brandRequestDto);

    CustomPageResponse<BrandResponseDto> getParameterizedCategories(Integer page, Integer size, String orden);
}
