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
    private M brand;

    public Article(Long id, String name, String description, Integer quantity, BigDecimal price, Set<T> categories, M brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.categories = categories;
        this.brand = brand;
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

    public M getBrand() {
        return brand;
    }

    public void setBrand(M brand) {
        this.brand = brand;
    }
}
