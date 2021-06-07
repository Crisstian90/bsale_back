package com.bsale.service;

import com.bsale.model.Category;
import com.bsale.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listAllUser() {
        return categoryRepository.findAll();
    }

    public Category getProductById(Integer id) {
        return categoryRepository.findById(id).get();
    }
    
}
