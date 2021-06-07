package com.bsale.controller;

import com.bsale.model.Product;
import com.bsale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<Product> list() {
        return productService.listAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = productService.getProductById(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }



}
