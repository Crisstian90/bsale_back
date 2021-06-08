package com.bsale.controller;

import com.bsale.model.Category;
import com.bsale.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    // Listar todas las categorias
    @GetMapping("")
    public ResponseEntity<List<Category>> listCategoryt(){
        List<Category> response = categoryService.listAllCategory();
        if(response.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<List<Category>>(response, HttpStatus.OK); 
        }
    }

    // Listar categorias por id
    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable Integer id) {
        try {
            Category category = categoryService.getCategoryById(id);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
            
        }
    }
    
}
