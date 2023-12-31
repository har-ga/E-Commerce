package com.educative.ecommerce.dto.product;


import com.educative.ecommerce.model.Product;

import javax.validation.constraints.NotNull;

public class ProductDto {

    private Integer id;
    private @NotNull String name;
    private @NotNull String imageURL;
    private @NotNull double price;
    private @NotNull String description;
    private @NotNull Integer categoryId;
    private @NotNull boolean active;

    // public ProductDto(@NotNull String name, @NotNull String imageURL, @NotNull double price, @NotNull String description, @NotNull Integer categoryId) {
    //     this.name = name;
    //     this.imageURL = imageURL;
    //     this.price = price;
    //     this.description = description;
    //     this.categoryId = categoryId;
    // }

    public ProductDto(Product product) {
        this.setId(product.getId());
        this.setName(product.getName());
        this.setImageURL(product.getImageURL());
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
        this.setCategoryId(product.getCategory().getId());
        this.setActive(product.isActive());
    }

    public ProductDto() {
    }

    public ProductDto(Integer id, @NotNull String name, @NotNull String imageURL, @NotNull double price,
            @NotNull String description, @NotNull Integer categoryId, @NotNull boolean active) {
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.active = active;
    }

    // public ProductDto(Integer id, @NotNull String name, @NotNull String imageURL, @NotNull double price,
    //         @NotNull String description, @NotNull Integer categoryId) {
    //     this.id = id;
    //     this.name = name;
    //     this.imageURL = imageURL;
    //     this.price = price;
    //     this.description = description;
    //     this.categoryId = categoryId;
    //     this.active = true;
    // }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
}
