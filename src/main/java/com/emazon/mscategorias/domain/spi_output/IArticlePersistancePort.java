package com.emazon.mscategorias.domain.spi_output;

import com.emazon.mscategorias.domain.model.Article;

import java.util.List;

public interface IArticlePersistancePort {
    Article saveArticle(Article article);

    List<Article> getAllArticles();

    Article getArticle(Long idArticle);

    void updateArticle(Article article);

    void deleteArticle(Long idArticle);
}
