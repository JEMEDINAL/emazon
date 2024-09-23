package com.emazon.mscategorias.domain.api_input;

import com.emazon.mscategorias.domain.model.Article;



public interface IArticleServicePort {
    void saveArticle(Article<Long,Long> article);


}
