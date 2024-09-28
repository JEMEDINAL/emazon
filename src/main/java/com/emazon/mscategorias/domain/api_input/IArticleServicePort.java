package com.emazon.mscategorias.domain.api_input;

import com.emazon.mscategorias.domain.model.Article;
import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.model.CustomPageResponse;


public interface IArticleServicePort {
    void saveArticle(Article<Long,Long> article);
    CustomPageResponse<Article<Category, Brand>> getParameterizedArticles(Integer page, Integer size, String orden);

}
