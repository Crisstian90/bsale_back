package com.bsale.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "product")
public class Product {
    
    @Id
    private Integer id;
    private String name;
    private String url_image;
    private float price;
    private Integer discount;
    private Integer category;

    public Product() {
    }

    public Product(int id, String name, String url_image, float price, Integer discount, Integer category) {
        this.id = id;
        this.name = name;
        this.url_image = url_image;
        this.price = price;
        this.discount = discount;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl_image() {
        return url_image;
    }
    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public Integer getDiscount() {
        return discount;
    }
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
    public Integer getCategory() {
        return category;
    }
    public void setCategory(Integer category) {
        this.category = category;
    }
    

}
