package com.emazon.mscategorias.application.handler;

import com.emazon.mscategorias.application.dto.ArticleRequestDto;
import com.emazon.mscategorias.application.dto.ArticleResponseDto;
import com.emazon.mscategorias.application.mapper.ArticleRequestMapper;
import com.emazon.mscategorias.domain.api_input.IArticleServicePort;
import com.emazon.mscategorias.domain.model.Article;
import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.model.CustomPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Override
    public CustomPageResponse<ArticleResponseDto> getParameterizedArticles(Integer page, Integer size, String orden) {
        CustomPageResponse<Article<Category, Brand>> pageResponse = iArticleServicePort.getParameterizedArticles(page, size, orden);
        List<ArticleResponseDto> responseDtos = articleRequestMapper.toResponseList(pageResponse.getContent());
        return new CustomPageResponse<>(responseDtos,pageResponse.getPage(),pageResponse.getSize(),
                pageResponse.getTotalElements(),pageResponse.getTotalPages(),pageResponse.getOrden());
    }
}
