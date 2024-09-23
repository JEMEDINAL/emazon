package com.emazon.mscategorias.domain.model;

import java.math.BigDecimal;
import java.util.Set;

public class Article<T,M> {
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private BigDecimal price;
    private Set<T> categories;
    private M idBrand;

    public Article(Long id, String name, String description, Integer quantity, BigDecimal price, Set<T> categories, M idBrand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.categories = categories;
        this.idBrand = idBrand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Set<T> getCategories() {
        return categories;
    }

    public void setCategories(Set<T> categories) {
        this.categories = categories;
    }

    public M getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(M idBrand) {
        this.idBrand = idBrand;
    }
}
