package com.ecommerceWeek7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @NotBlank(message = "Product name is mandatory")
    private String productName;

    private String productDesc;

    private String productCategory;

    @NotBlank(message = "Product Price is mandatory")
    private double productPrice;

    private String productImage;
    private int productQty;

}
