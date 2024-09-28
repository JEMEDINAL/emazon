package com.emazon.mscategorias.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponseDto {

    private String name;
    private String description;
    private Integer quantity;
    private BigDecimal price;
    private Set<CategoryResponseDto> categories;
    private BrandResponseDto idBrand;
}
