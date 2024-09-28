package com.emazon.mscategorias.application.handler;

import com.emazon.mscategorias.application.dto.ArticleRequestDto;
import com.emazon.mscategorias.application.dto.ArticleResponseDto;
import com.emazon.mscategorias.domain.model.CustomPageResponse;

public interface IArticleHandler {
    void saveArticle(ArticleRequestDto articleRequestDto);

    CustomPageResponse<ArticleResponseDto> getParameterizedArticles(Integer page, Integer size, String orden);
}
