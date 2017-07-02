/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.kieckegard.github.product.inventory.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Pedro Arthur
 */
public class ProductInventory {
    
    private final List<Product> products;
    private static Long idCount = 0L;
    
    public ProductInventory() {
        this.products = new ArrayList<>();
    }
    
    public boolean add(String description, BigDecimal price, Integer stock) {
        idCount++;
        return products.add(new Product(idCount, description, price, stock));
    }
    
    public boolean remove(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
    
    public Integer productCount() {
        return products.size();
    }
    
    public Optional<Product> findById(Long id) {
        return products.stream().filter(p -> p.getId()
                .equals(id))
                .findFirst();
    }
    
    public Integer getTotalStock() {
        Integer qty = 0;
        qty = this.products.stream()
                .map((p) -> p.getStock())
                .reduce(qty, Integer::sum);
        return qty;
    }
    
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        totalPrice = this.products.stream()
                .map((p) -> p.getPrice())
                .reduce(totalPrice, (t, u) -> {
                    return t.add(u);
                });
        return totalPrice;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }
   
}
