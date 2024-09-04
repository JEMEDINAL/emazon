package com.emazon.mscategorias.infrastructure.input.rest;

import com.emazon.mscategorias.application.dto.BrandRequestDto;

import com.emazon.mscategorias.application.handler.IBrandHandler;
import com.emazon.mscategorias.infrastructure.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {
    private final IBrandHandler iBrandHandler;

    @PostMapping
    public ResponseEntity<ApiResponse> saveBrand(@RequestBody BrandRequestDto brandRequestDto){
        iBrandHandler.saveBrandInBrandsDb(brandRequestDto);
        ApiResponse response = new ApiResponse("Tu Marca se ha guardado exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
