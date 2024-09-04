package com.emazon.mscategorias.infrastructure.out.jpa.repository;

import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.infrastructure.out.jpa.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBrandRepository extends JpaRepository<BrandEntity,Long> {
    Optional<Brand> findByName(String name);
}
