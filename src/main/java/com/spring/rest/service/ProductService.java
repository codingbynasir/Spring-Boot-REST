package com.spring.rest.service;

import com.spring.rest.model.Product;

import java.util.Collection;

public interface ProductService {
    public abstract void createProduct(Product product);
    public abstract void updateProduct(int id, Product product);
    public abstract void deleteProduct(int id);
    public abstract Collection<Product> getProducts();
    public abstract Product retrieveProducts(int id);
}
