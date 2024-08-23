package com.emazon.mscategorias.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponseDto {
    private Integer quantity;
    private BigDecimal price;
}
