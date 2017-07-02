/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.kieckegard.github.product.inventory.entities;

import java.math.BigDecimal;

/**
 *
 * @author Pedro Arthur
 */
public class Product {
    
    private Long id;
    private String description;
    private BigDecimal price;
    private Integer stock;

    public Product(Long id, String description, BigDecimal price, Integer stock) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }
    
    public void add(Integer stock) {
        if(stock <= 0)
            throw new IllegalArgumentException("Put a value greater than zero.");
        this.stock += stock;
    }
    
    public void remove(Integer stock) {
        if(stock <= 0)
            throw new IllegalArgumentException("Put a value greater than zero.");
        if(stock > this.stock)
            throw new IllegalArgumentException("You haven't stock enought.");
        this.stock -= stock;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", description=" + description + ", price=" + price + ", stock=" + stock + '}';
    }
}
