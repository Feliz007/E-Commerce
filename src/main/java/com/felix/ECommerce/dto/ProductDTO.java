package com.ecommerceWeek7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor @NoArgsConstructor
@Component
public class ProductDTO {


    @NotBlank(message = "Product name is mandatory")

    private String productName;

    private String productDesc;

    private String productCategory;

    @NotBlank(message = "Product Price is mandatory")
    private double productPrice;

    private String productImage;
    private int productQty;
}
