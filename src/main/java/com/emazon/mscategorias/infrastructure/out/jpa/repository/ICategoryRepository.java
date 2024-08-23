package com.emazon.mscategorias.infrastructure.out.jpa.repository;

import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.CategoryEntiy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ICategoryRepository extends JpaRepository<CategoryEntiy,Long> {
    Optional<Category> findByName(String name);
}
