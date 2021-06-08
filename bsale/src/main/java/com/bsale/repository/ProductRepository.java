package com.bsale.repository;

import com.bsale.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    public List<Product> findByCategory(Integer category);

    @Query("SELECT p FROM Product p WHERE p.name like ?1%")
    public List<Product> findByLetter(String word);


    // Paginacion buscar por categoria
    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    Page <Product> findByCategoryPage(Integer category, Pageable p);

    // Paginacion buscar por palabra
    @Query("SELECT p FROM Product p WHERE p.name like ?1%")
    Page <Product> findProductPage(String word, Pageable p);

}