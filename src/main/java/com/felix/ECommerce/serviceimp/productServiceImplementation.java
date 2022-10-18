package com.implementation;

import com.ecommerceWeek7.dto.ProductDTO;
import com.ecommerceWeek7.model.Product;
import com.ecommerceWeek7.repository.ProductRepository;
import com.ecommerceWeek7.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productServiceImplementation implements ProductService {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDTO productDTO;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }



    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public Boolean deleteProductById(Long id) {
        if (this.findProductById(id) == null) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    public Product productDtoToEntity(ProductDTO productDTO){
        Product product1 = new Product();
        product1.setProductName(productDTO.getProductName());
        product1.setProductPrice(productDTO.getProductPrice());
        product1.setProductQty(productDTO.getProductQty());
        product1.setProductDesc(productDTO.getProductDesc());
        product1.setProductCategory(productDTO.getProductCategory());



        return saveProduct(product1);
    }
}
