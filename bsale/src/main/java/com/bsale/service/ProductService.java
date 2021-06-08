package com.bsale.service;

import com.bsale.model.Product;
import com.bsale.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> listAllProductos() {
        return productRepository.findAll();
    }
    
    public Page<Product> listAllProductosPage(Integer page) {
        Pageable pageable = PageRequest.of(page,10);
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage;
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getProductByCategory(String id_category) {
        return productRepository.findByCategory(Integer.parseInt(id_category));
    }

    public List<Product> getProductByLetter(String word) {
        return productRepository.findByLetter(word);
    }
}
