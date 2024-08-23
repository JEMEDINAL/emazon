package com.emazon.mscategorias.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDto {
    private long id;
    private String name;
    private String description;
}
