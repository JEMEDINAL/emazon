package com.emazon.mscategorias.infrastructure.input.rest;

import com.emazon.mscategorias.application.dto.BrandRequestDto;

import com.emazon.mscategorias.application.dto.BrandResponseDto;
import com.emazon.mscategorias.application.handler.IBrandHandler;
import com.emazon.mscategorias.domain.model.CustomPageResponse;
import com.emazon.mscategorias.infrastructure.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<CustomPageResponse<BrandResponseDto>> getParameterizedCategories(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer size,
                                                                                           @RequestParam(required = false) String orden){
        CustomPageResponse<BrandResponseDto> response = iBrandHandler.getParameterizedCategories(page, size, orden);
        return ResponseEntity.ok(response);
    }
}
