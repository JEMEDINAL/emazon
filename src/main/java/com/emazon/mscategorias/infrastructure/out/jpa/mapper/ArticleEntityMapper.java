package com.emazon.mscategorias.infrastructure.out.jpa.mapper;

import com.emazon.mscategorias.domain.model.Article;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.ArticleEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface ArticleEntityMapper {

    @Mapping(target = "categories",ignore = true)
    @Mapping(target = "brand",ignore = true)
    ArticleEntity articleToArticleEntity(Article<Long,Long> article);
}
