package com.emazon.mscategorias.infrastructure.configuration;


import com.emazon.mscategorias.domain.api_input.IArticleServicePort;
import com.emazon.mscategorias.domain.spi_output.IArticlePersistancePort;
import com.emazon.mscategorias.domain.usecase.ArticleUseCase;
import com.emazon.mscategorias.infrastructure.out.jpa.adapter.ArticleJpaAdapter;
import com.emazon.mscategorias.infrastructure.out.jpa.mapper.ArticleEntityMapper;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.IArticleRepository;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.IBrandRepository;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ArticleConfiguration {
    private final IArticleRepository iArticleRepository;
    private final ICategoryRepository iCategoryRepository;
    private final ArticleEntityMapper articleEntityMapper;
    private final IBrandRepository iBrandRepository;

    @Bean
    public IArticlePersistancePort articlePersistancePort(){
        return new ArticleJpaAdapter(iArticleRepository,articleEntityMapper,iCategoryRepository,iBrandRepository);
    }

    @Bean
    IArticleServicePort articleServicePort(){
        return new ArticleUseCase(articlePersistancePort());
    }
}
