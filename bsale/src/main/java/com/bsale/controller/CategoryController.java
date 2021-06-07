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

    @GetMapping("")
    public List<Category> list() {
        return categoryService.listAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable Integer id) {
        try {
            Category category = categoryService.getProductById(id);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }
    
}
