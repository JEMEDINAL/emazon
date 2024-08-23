package com.emazon.mscategorias.infrastructure.out.jpa.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jakarta.persistence.*;
import lombok.*;

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
}
