package com.spring.rest.controller;

import com.spring.rest.model.Product;
import com.spring.rest.service.ProductService;
import com.spring.rest.service.ProductServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    ProductService productService= new ProductServiceImplementation();
    @RequestMapping(value = "/product/", method = RequestMethod.POST)
    public ResponseEntity<Object>postProduct(@RequestBody Product data){
        productService.createProduct(data);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> retrieveProduct(@PathVariable("id") int id){
        return new ResponseEntity<>(productService.retrieveProducts(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> putProduct(@PathVariable("id") int id, @RequestBody Product data){
        productService.updateProduct(id, data);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is removed", HttpStatus.OK);
    }
}
