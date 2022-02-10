package com.example.shaiyav2.service.shop;


import com.example.shaiyav2.entity.product.Products;
import com.example.shaiyav2.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl {
    @Autowired
    ProductRepository productRepository;

    public List<Products> allProducts(){
        return productRepository.findAll();
    }
}
