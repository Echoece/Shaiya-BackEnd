package com.example.shaiyav2.repository.product;

import com.example.shaiyav2.entity.product.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

    @Query(value = "select * from PS_UserData.dbo.Products",nativeQuery = true)
    List<Products> allProducts();

    Products findProductsById(Long id);
}
