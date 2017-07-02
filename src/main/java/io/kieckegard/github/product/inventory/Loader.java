/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.kieckegard.github.product.inventory;

import java.math.BigDecimal;
import java.util.Optional;

/**
 *
 * @author Pedro Arthur
 */
public class Loader {
    
    private static ProductInventory inventory;
    
    public static void main(String[] args) {
        
        inventory = new ProductInventory();
        
        inventory.add("Apple", new BigDecimal(1.50d), 30);
        inventory.add("Orange", new BigDecimal(1d), 65);
        inventory.add("Popcorn", new BigDecimal(1.25d), 12);
       
        System.out.println("Products: " + inventory.getProducts());
        System.out.println("Product count: " + inventory.productCount());
        System.out.println("Products total Stock: " + inventory.getTotalStock());
        System.out.println("Products total price: " + inventory.getTotalPrice());
        System.out.println("Found by id [2]: " + inventory.findById(2L).get());

    }
}
