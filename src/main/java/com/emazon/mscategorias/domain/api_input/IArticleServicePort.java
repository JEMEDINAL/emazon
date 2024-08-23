package com.emazon.mscategorias.domain.api_input;

import com.emazon.mscategorias.domain.model.Article;

import java.util.List;

public interface IArticleServicePort {
    void saveArticle(Article article);

    List<Article> getAllArticles();

    Article getArticle(Long idArticle);

    void updateArticle(Article article);

    void deleteArticle(Long idArticle);

}
