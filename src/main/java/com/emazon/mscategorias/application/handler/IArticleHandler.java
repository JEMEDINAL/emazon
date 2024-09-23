package com.emazon.mscategorias.application.handler;

import com.emazon.mscategorias.application.dto.ArticleRequestDto;

public interface IArticleHandler {
    void saveArticle(ArticleRequestDto articleRequestDto);
}
