package com.emazon.mscategorias.domain.model;

import java.math.BigDecimal;

public class Article {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private Long idCategory;
    private Long idBrand;

    public Article(Long id, Integer quantity, BigDecimal price, Long idCategory, Long idBrand) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.idCategory = idCategory;
        this.idBrand = idBrand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Long getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Long idBrand) {
        this.idBrand = idBrand;
    }
}
