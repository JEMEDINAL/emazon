package com.emazon.mscategorias.infrastructure.input.rest;


import com.emazon.mscategorias.application.dto.CategoryRequestDto;
import com.emazon.mscategorias.application.dto.CategoryResponseDto;
import com.emazon.mscategorias.application.handler.ICategoryHandler;
import com.emazon.mscategorias.domain.model.CustomPageResponse;
import com.emazon.mscategorias.infrastructure.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryHandler iCategoryHandler;


    @PostMapping
    public ResponseEntity<ApiResponse> saveCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto){
        iCategoryHandler.saveCategoryInCategoriesDb(categoryRequestDto);
        ApiResponse response = new ApiResponse("Tu Categoria se ha guardado exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping
    public  ResponseEntity<CustomPageResponse<CategoryResponseDto>> getParameterizedCategories(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String orden
    ){
        CustomPageResponse<CategoryResponseDto> response = iCategoryHandler.getParameterizedCategories(page, size, orden);
        return ResponseEntity.ok(response);

    }
}
