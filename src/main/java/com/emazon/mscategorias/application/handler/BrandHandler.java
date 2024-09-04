package com.emazon.mscategorias.application.handler;

import com.emazon.mscategorias.application.dto.BrandRequestDto;
import com.emazon.mscategorias.application.mapper.BrandRequestMapper;
import com.emazon.mscategorias.domain.api_input.IBrandServicePort;
import com.emazon.mscategorias.domain.model.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
