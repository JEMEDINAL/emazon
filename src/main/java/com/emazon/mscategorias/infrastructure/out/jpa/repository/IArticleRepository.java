package com.emazon.mscategorias.infrastructure.out.jpa.repository;

import com.emazon.mscategorias.infrastructure.out.jpa.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticleRepository extends JpaRepository<ArticleEntity,Long> {
}
