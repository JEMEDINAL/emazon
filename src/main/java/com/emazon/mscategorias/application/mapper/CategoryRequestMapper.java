package com.emazon.mscategorias.application.mapper;

import com.emazon.mscategorias.application.dto.CategoryRequestDto;
import com.emazon.mscategorias.domain.model.Category;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryRequestMapper {
    Category toCategory(CategoryRequestDto categoryRequestDto);
}
