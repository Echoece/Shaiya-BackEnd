package com.example.shaiyav2.entity.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity(name = "Products")
@NoArgsConstructor
public class Products {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String category;
  private long price;
  private String description;
  private String image;
  @Column(name = "product_id")
  @JsonIgnore
  private long productId;
}
