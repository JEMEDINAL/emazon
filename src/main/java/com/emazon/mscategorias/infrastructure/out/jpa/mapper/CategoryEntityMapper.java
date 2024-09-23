package com.emazon.mscategorias.infrastructure.out.jpa.mapper;



import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.CategoryEntiy;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

    CategoryEntiy toEntity(Category category);
    List<Category> toListCategory(List<CategoryEntiy> categoryList);

}
