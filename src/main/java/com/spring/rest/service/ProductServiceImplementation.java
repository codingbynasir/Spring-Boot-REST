package com.spring.rest.service;

import com.spring.rest.controller.Exception.ProductNotFoundException;
import com.spring.rest.model.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductServiceImplementation implements ProductService{

    public static Map<Integer, Product> product=new HashMap<>();
    static {
        Product honey=new Product();
        honey.setId(1);
        honey.setName("Honey");

        product.put(honey.getId(), honey);
        Product mango=new Product();
        mango.setId(2);
        mango.setName("Mango");

        product.put(mango.getId(), mango);
    }

    @Override
    public void createProduct(Product p) {
        product.put(p.getId(), p);
    }

    @Override
    public void updateProduct(int id, Product p) {
        if(!product.containsKey(id))throw new ProductNotFoundException();
        product.remove(id);
        Product prdt=new Product();
        prdt.setId(p.getId());
        prdt.setName(p.getName());
        product.put(p.getId(), prdt);
    }

    @Override
    public void deleteProduct(int id) {
        if (!product.containsKey(id)) throw new ProductNotFoundException();
        product.remove(id);
    }

    @Override
    public Collection<Product> getProducts() {
        return product.values();
    }

    @Override
    public Product retrieveProducts(int id) {
        if (!product.containsKey(id)) throw new ProductNotFoundException();
        return product.get(id);
    }
}
