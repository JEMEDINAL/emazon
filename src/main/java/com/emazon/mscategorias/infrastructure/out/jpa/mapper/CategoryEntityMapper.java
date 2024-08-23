package com.emazon.mscategorias.infrastructure.out.jpa.mapper;


import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.CategoryEntiy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        unmappedSourcePolicy = ReportingPolicy.WARN)
public interface CategoryEntityMapper {

    CategoryEntiy toEntity(Category category);
}
