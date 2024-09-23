package com.emazon.mscategorias.domain.usecase;

import com.emazon.mscategorias.domain.api_input.IArticleServicePort;
import com.emazon.mscategorias.domain.model.Article;
import com.emazon.mscategorias.domain.spi_output.IArticlePersistancePort;
import com.emazon.mscategorias.infrastructure.exception.*;

import java.math.BigDecimal;

import static com.emazon.mscategorias.domain.usecase.constants.ArticleUseCaseConstants.*;

public class ArticleUseCase implements IArticleServicePort {

    private final IArticlePersistancePort iArticlePersistancePort;

    public ArticleUseCase(IArticlePersistancePort iArticlePersistancePort) {
        this.iArticlePersistancePort = iArticlePersistancePort;
    }

    @Override
    public void saveArticle(Article<Long,Long> article) {
        if (article.getName() == null || article.getName().isEmpty()||article.getName().length() >= MAX_CHARACTERS_ARTICLE_NAME){
            throw new NameNotBlankException();
        }
        if (article.getDescription() == null || article.getDescription().isEmpty()||article.getDescription().length() >= MAX_CHARACTERS_ARTICLE_DESCRIPTION){
            throw new ValidDescription();
        }
        if (article.getQuantity() == null || article.getQuantity() < MIN_QUANTITY_ARTICLE){
            throw  new ValidQuantity();
        }
        if (article.getPrice() == null || article.getPrice().compareTo(BigDecimal.ZERO) < MIN_PRICE_ARTICLE){
            throw new ValidPrice();
        }

        if(article.getCategories().size() == EMPTY_CATEGORIES || article.getCategories().size() > MAX_CATEGORIES_IDS ){
            throw new ValidIdsCategories();
        }

        iArticlePersistancePort.saveArticle(article);

    }
}
