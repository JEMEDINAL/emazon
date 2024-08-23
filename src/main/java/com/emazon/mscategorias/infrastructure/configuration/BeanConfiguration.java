package com.emazon.mscategorias.infrastructure.configuration;


import com.emazon.mscategorias.domain.api_input.ICategoryServicePort;
import com.emazon.mscategorias.domain.spi_output.ICategoryPersistancePort;
import com.emazon.mscategorias.domain.usecase.CategoryUseCase;
import com.emazon.mscategorias.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.emazon.mscategorias.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistancePort categoryPersistancePort(){
        return new CategoryJpaAdapter(categoryRepository ,categoryEntityMapper);
    }

    @Bean
    @Primary
    ICategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistancePort());
    }
}

