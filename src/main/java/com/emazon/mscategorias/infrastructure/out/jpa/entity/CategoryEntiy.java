package com.emazon.mscategorias.infrastructure.out.jpa.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryEntiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String name;


    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<ArticleEntity> articles = new HashSet<>();
}
