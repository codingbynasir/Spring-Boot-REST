package com.spring.rest.controller;

import com.spring.rest.controller.Exception.ProductNotFoundException;
import com.spring.rest.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {
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
    @RequestMapping(value = "/product/", method = RequestMethod.POST)
    public ResponseEntity<Object>postProduct(@RequestBody Product data){
        Product prdt=new Product();
        prdt.setId(data.getId());
        prdt.setName(data.getName());
        product.put(prdt.getId(), prdt);
        return new ResponseEntity<>(product.values(), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(product.values(), HttpStatus.OK);
    }
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> retrieveProduct(@PathVariable("id") int id){
        if(!product.containsKey(id))throw new ProductNotFoundException();
        Product dts=product.get(id);
        return new ResponseEntity<>(dts, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> putProduct(@PathVariable("id") int id, @RequestBody Product data){
        if(!product.containsKey(id))throw new ProductNotFoundException();
        product.remove(id);
        Product prdt=new Product();
        prdt.setId(data.getId());
        prdt.setName(data.getName());
        product.put(data.getId(), prdt);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id){
        if (!product.containsKey(id)) throw new ProductNotFoundException();
        product.remove(id);
        return new ResponseEntity<>("Product is removed", HttpStatus.OK);
    }
}
