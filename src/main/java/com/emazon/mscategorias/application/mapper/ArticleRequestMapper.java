package com.emazon.mscategorias.application.mapper;

import com.emazon.mscategorias.application.dto.ArticleRequestDto;
import com.emazon.mscategorias.application.dto.ArticleResponseDto;
import com.emazon.mscategorias.application.dto.BrandResponseDto;
import com.emazon.mscategorias.application.dto.CategoryResponseDto;
import com.emazon.mscategorias.domain.model.Article;
import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.domain.model.Category;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface ArticleRequestMapper {
    BrandResponseDto toResponseDto(Brand brand);

    Article<Long,Long> articleDtoToArticle(ArticleRequestDto articleRequestDto);

    default List<ArticleResponseDto> toResponseList(List<Article<Category, Brand>> articleList){
        return articleList.stream()
                .map(article ->{
                    ArticleResponseDto articleResponseDto = new ArticleResponseDto();
                    articleResponseDto.setName(article.getName());
                    articleResponseDto.setDescription(article.getDescription());
                    articleResponseDto.setQuantity(article.getQuantity());
                    articleResponseDto.setPrice(article.getPrice());

                    Set<CategoryResponseDto> categoryResponseDtos = article.getCategories().stream()
                            .map(category -> new CategoryResponseDto(category.getName(), category.getDescription()))
                            .collect(Collectors.toSet());
                    articleResponseDto.setCategories(categoryResponseDtos);
                    BrandResponseDto brandResponseDto = toResponseDto(article.getBrand());
                    articleResponseDto.setIdBrand(brandResponseDto);

                    return articleResponseDto;
                })
                .collect(Collectors.toList());
    }
}
