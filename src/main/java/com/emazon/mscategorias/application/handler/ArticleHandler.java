package com.emazon.mscategorias.application.handler;

import com.emazon.mscategorias.application.dto.ArticleRequestDto;
import com.emazon.mscategorias.application.mapper.ArticleRequestMapper;
import com.emazon.mscategorias.domain.api_input.IArticleServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class ArticleHandler implements IArticleHandler{

    private final IArticleServicePort iArticleServicePort;
    private final ArticleRequestMapper articleRequestMapper;

    @Override
    public void saveArticle(ArticleRequestDto articleRequestDto) {
        iArticleServicePort.saveArticle(articleRequestMapper.articleDtoToArticle(articleRequestDto));

    }
}
