package com.ecommerceWeek7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;



  @ManyToOne
 @JoinColumn(name = "product_Id", nullable = false)
  private Product product;

  @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
 @JoinColumn(nullable = false, name = "user_id")
  private User user;

  private int quantity;

  public Cart(Product product, int quantity, User user){
    this.user = user;
    this.product = product;
    this.quantity = quantity;

  }
}
