package com.bsale.controller;

import com.bsale.model.Product;
import com.bsale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;


import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    ProductService productService;

    // Listar todo los productos
    @GetMapping("")
    public List<Product> listAllProduct() {
        return productService.listAllProductos();
    }

    // Listar todo los productos por pagina
    @GetMapping("/page/{numPag}")
    public Page<Product> listAllProductPage(@PathVariable Integer numPag) {
        return productService.listAllProductosPage(numPag);
    }

    // Buscar productos por id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        try {
            Product product = productService.getProductById(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    // Buscar productos por categoria
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> listProductByCategory(@PathVariable String id) {
        List<Product> response = productService.getProductByCategory(id);
        if(response.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<List<Product>>(response, HttpStatus.OK); 
        }
    }

    // Buscar productos por palabra
    @GetMapping("/search/{words}")
    public ResponseEntity<List<Product>> listFindProduct(@PathVariable String words) {
        List<Product> response = productService.getProductByLetter(words);
        if(response.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<List<Product>>(response, HttpStatus.OK); 
        }
    }
}
