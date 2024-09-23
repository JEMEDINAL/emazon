package com.emazon.mscategorias.infrastructure.out.jpa.mapper;

import com.emazon.mscategorias.domain.model.Article;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.ArticleEntity;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.BrandEntity;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.CategoryEntiy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface ArticleEntityMapper {

    @Mapping(target = "categories",ignore = true)
    @Mapping(target = "idBrand",ignore = true)
    Article<CategoryEntiy, BrandEntity> toArticle(Article<Long,Long> article);

    ArticleEntity articleToArticleEntity(Article<CategoryEntiy,BrandEntity> article);
}
