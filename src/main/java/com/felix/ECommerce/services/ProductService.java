package com.ecommerceWeek7.services;

import com.ecommerceWeek7.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();

    public Product findProductById(Long id);

    public Product saveProduct(Product product);

    public Product updateProduct(Product product);


    public Boolean deleteProductById(Long id);
}
