package com.emazon.mscategorias.infrastructure.out.jpa.adapter;

import com.emazon.mscategorias.domain.model.Article;
import com.emazon.mscategorias.domain.spi_output.IArticlePersistancePort;
import com.emazon.mscategorias.infrastructure.exception.NoExistCategories;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.ArticleEntity;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.BrandEntity;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.CategoryEntiy;
import com.emazon.mscategorias.infrastructure.out.jpa.mapper.ArticleEntityMapper;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.IArticleRepository;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.IBrandRepository;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ArticleJpaAdapter implements IArticlePersistancePort {
    private final IArticleRepository iArticleRepository;
    private final ArticleEntityMapper articleEntityMapper;
    private final ICategoryRepository categoryRepository;
    private final IBrandRepository iBrandRepository;

    @Override
    public void saveArticle(Article<Long,Long> article) {
        BrandEntity brand = iBrandRepository.findById(article.getBrand())
                .orElseThrow(NoExistCategories::new);

        Set<CategoryEntiy> categoryEntities = article.getCategories().stream()
                .map(categoryRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        if (categoryEntities.size() != article.getCategories().size()) {
            throw new NoExistCategories();
        }
        ArticleEntity articleEntity = articleEntityMapper.articleToArticleEntity(article);
        articleEntity.setCategories(categoryEntities);
        articleEntity.setBrand(brand);

        iArticleRepository.save(articleEntity);

    }
}
