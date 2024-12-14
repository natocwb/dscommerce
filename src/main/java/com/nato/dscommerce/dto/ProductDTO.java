package com.nato.dscommerce.dto;

import com.nato.dscommerce.entities.Category;
import com.nato.dscommerce.entities.Product;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private Long id;
    @NotBlank(message = "Description cannot be empty")
    @Size(min = 3, max = 80, message = "Name must have between 3 and 80 characters")
    private String name;
    @NotBlank(message = "Description cannot be empty")
    @Size(min = 10, message = "Description must have between 10 and 255 characters")
    @Column(columnDefinition = "TEXT")
    private String description;
    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be greater than zero")
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Categories cannot be empty")
    private List<CategoryDTO> categories = new ArrayList<>();


    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
        for (Category c : product.getCategories()) {
            categories.add(new CategoryDTO(c));
        }
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
