package com.emazon.mscategorias.application.mapper;

import com.emazon.mscategorias.application.dto.CategoryRequestDto;
import com.emazon.mscategorias.application.dto.CategoryResponseDto;
import com.emazon.mscategorias.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CategoryRequestMapper {

    Category toCategory(CategoryRequestDto categoryRequestDto);





    default List<CategoryResponseDto> toResponseList(List<Category> categoryList){
        return categoryList.stream()
                .map(category -> {
                    CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
                    categoryResponseDto.setName(category.getName());
                    categoryResponseDto.setDescription(category.getDescription());
                    return categoryResponseDto;
                }).toList();
    }
}
