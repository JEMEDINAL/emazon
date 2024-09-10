package com.emazon.mscategorias.infrastructure.configuration;

import com.emazon.mscategorias.domain.api_input.IBrandServicePort;
import com.emazon.mscategorias.domain.spi_output.IBrandPersistancePort;
import com.emazon.mscategorias.domain.usecase.BrandUseCase;
import com.emazon.mscategorias.infrastructure.out.jpa.adapter.BrandJpaAdapter;
import com.emazon.mscategorias.infrastructure.out.jpa.mapper.IBrandEntityMapper;
import com.emazon.mscategorias.infrastructure.out.jpa.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@RequiredArgsConstructor
public class BrandConfiguration {
    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper iBrandEntityMapper;

    @Bean
    public IBrandPersistancePort brandPersistancePort(){
        return new BrandJpaAdapter(brandRepository ,iBrandEntityMapper);
    }

    @Bean
    @Primary
    IBrandServicePort brandServicePort(){
        return new BrandUseCase(brandPersistancePort());
    }
}
