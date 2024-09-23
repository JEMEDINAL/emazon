package com.emazon.mscategorias.domain.spi_output;

import com.emazon.mscategorias.domain.model.Article;



public interface IArticlePersistancePort {
    void saveArticle(Article<Long,Long> article);

}
