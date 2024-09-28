package com.emazon.mscategorias.infrastructure.out.jpa.adapter;

import com.emazon.mscategorias.domain.model.Article;
import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.model.CustomPageResponse;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
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

    @Override
    public CustomPageResponse<Article<Category, Brand>> getParameterizedArticles(Integer page, Integer size, String orden) {
        String[] parts = orden.split(",");

        String property = parts[0];
        String direction = parts[1];

        Sort sort = Sort.by(Sort.Direction.fromString(direction),property);


        Pageable pageable = PageRequest.of(page,size,sort);
        Page<ArticleEntity> articleEntityPage = iArticleRepository.findAll(pageable);
        List<Article<Category,Brand>> articleEntities = articleEntityMapper.toListArticle(articleEntityPage.getContent());
        return new CustomPageResponse<>(articleEntities, articleEntityPage.getNumber(), articleEntityPage.getSize(),
                articleEntityPage.getTotalElements(), articleEntityPage.getTotalPages(), orden);
    }
}
