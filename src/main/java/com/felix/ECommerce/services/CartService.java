package com.ecommerceWeek7.services;

import com.ecommerceWeek7.dto.AddToCartDto;
import com.ecommerceWeek7.dto.CartDto;
import com.ecommerceWeek7.model.Product;
import com.ecommerceWeek7.model.User;

public interface CartService {
    public void addToCart(AddToCartDto addToCartDto, Product product, User user);


    public void deleteCartItem(int cartItemId, User user);
    ;
}
