package com.emazon.mscategorias.application.handler;

import com.emazon.mscategorias.application.dto.BrandRequestDto;

public interface IBrandHandler {
    void saveBrandInBrandsDb(BrandRequestDto brandRequestDto);
}
