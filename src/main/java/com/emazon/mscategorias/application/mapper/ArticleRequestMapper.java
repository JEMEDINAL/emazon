package com.emazon.mscategorias.application.mapper;

import com.emazon.mscategorias.application.dto.ArticleRequestDto;
import com.emazon.mscategorias.domain.model.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleRequestMapper {

    Article<Long,Long> articleDtoToArticle(ArticleRequestDto articleRequestDto);
}
