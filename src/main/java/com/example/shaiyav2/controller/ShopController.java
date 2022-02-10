package com.example.shaiyav2.controller;


import com.example.shaiyav2.configuration.jwt.JwtTokenUtil;
import com.example.shaiyav2.entity.product.CheckoutDTO;
import com.example.shaiyav2.entity.product.Products;
import com.example.shaiyav2.repository.product.ProductRepository;
import com.example.shaiyav2.repository.usermaster.UsersMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// todo: /checkout => execute the stored proc to send item to players on success and deduct user point.

@RestController
@RequestMapping("/api/v1/shop")
@CrossOrigin
public class ShopController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UsersMasterRepository usersMasterRepository;


    @GetMapping("/products")
    public List<Products> allProducts(){
        return productRepository.allProducts();
    }

    // add a new product, will be disabled in the production
    @PostMapping("/products")
    public void saveProduct(@RequestBody @Valid Products product){
        productRepository.save(product);
    }




    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody List<CheckoutDTO> products , @RequestHeader (name="Authorization") String token) {
        // calculating total price
        int totalprice=0;
        for (CheckoutDTO product: products
             ) {
            totalprice += productRepository.findProductsById(product.getId()).getPrice()*product.getQuantity();
        }

        // getting user name from token, passed in header with request
        String jwtToken = token.split(" ")[1];
        String userName = jwtTokenUtil.getUsernameFromToken(jwtToken);

        // getting users currency point
        long point = usersMasterRepository.getUsersMasterByUserId(userName).getPoint();

        if (point >= totalprice){
            System.out.println("successful");
            return ResponseEntity.ok( "success!");
        }else{
            System.out.println("failed... not enough point");
            return ResponseEntity.ok("failed");
        }
    }
}
