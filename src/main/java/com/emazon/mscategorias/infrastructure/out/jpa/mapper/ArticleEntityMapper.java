package com.emazon.mscategorias.infrastructure.out.jpa.mapper;

import com.emazon.mscategorias.domain.model.Article;
import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.ArticleEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ArticleEntityMapper {

    @Mapping(target = "categories",ignore = true)
    @Mapping(target = "brand",ignore = true)
    ArticleEntity articleToArticleEntity(Article<Long,Long> article);

    List<Article<Category, Brand>> toListArticle(List<ArticleEntity> articleEntityList);

}
