package com.implementation;

import com.ecommerceWeek7.dto.AddToCartDto;
import com.ecommerceWeek7.dto.CartDto;
import com.ecommerceWeek7.dto.CartItemDto;
import com.ecommerceWeek7.model.Cart;
import com.ecommerceWeek7.model.Product;
import com.ecommerceWeek7.model.Roles;
import com.ecommerceWeek7.model.User;
import com.ecommerceWeek7.repository.CartRepository;
import com.ecommerceWeek7.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartServiceImplementation implements CartService {
    @Autowired
    private CartRepository cartRepository;

    public void addToCart(AddToCartDto addToCartDto, Product product, User user) {
        if(user.getRole()== Roles.CUSTOMER){
            Cart cart = new Cart(product, addToCartDto.getQuantity(), user);
            cartRepository.save(cart);
        }

    }

//    public CartDto listCartItems(User user) {
//        List<CartItemDto> cartItems = null;
//        double totalCost = 0;
//        if(user.getRole() == Roles.CUSTOMER){
//            // first get all the cart items for user
//            List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
//
//            // convert cart to cartItemDto
//             cartItems = new ArrayList<>();
//            for (Cart cart : cartList) {
//                CartItemDto cartItemDto = new CartItemDto(cart);
//                cartItems.add(cartItemDto);
//            }
//
//            // calculate the total price
//             totalCost = 0;
//            for (CartItemDto cartItemDto : cartItems) {
//                totalCost += cartItemDto.getProduct().getProductPrice() * cartItemDto.getQuantity();
//            }
//
//
//        }
//        // return cart DTO
//        return new CartDto(cartItems, totalCost);
//
//    }

    public Boolean findProductById(int cartItemId, User user){
         boolean message = false;


        Optional<Cart> optionalCart = cartRepository.findById((long) cartItemId);

        if (!optionalCart.isPresent()) {
            System.out.println("cartItemId not valid");


        }

        // next check if the cartItem belongs to the user else throw CartItemNotExistException exception

        Cart cart = optionalCart.get();

        if (cart.getUser() != user) {
            System.out.println("cart item does not belong to user");

        }
        return true;

    }

    public void deleteCartItem(int cartItemId, User user) {
        //TODO
        if(user.getRole()== Roles.CUSTOMER){
            // first check if cartItemId is valid else throw an CartItemNotExistException
          if(findProductById(cartItemId,user)== true){
              cartRepository.deleteById((long) cartItemId);
              // delete the cart item
          }

        }
    }


//    @Override
//    public void IncreaseAndReduceCartItem(int cartItemId, User user, Cart cart) {
//        if(user.getRole() == Roles.CUSTOMER){
//            if(findProductById(cartItemId,user)== true){
//                for(Cart)
//            }
//
//
//        }

//        (PrintWriter out = response.getWriter()) {
//            String action = request.getParameter("action");
//            int id = Integer.parseInt(request.getParameter("id"));
//            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
//            if (action != null && id >= 1) {
//                if (action.equals("inc")) {
//                    for (Cart c : cart_list) {
//                        if (c.getId() == id) {
//                            int quantity = c.getQuantity();
//                            quantity++;
//                            c.setQuantity(quantity);
//                            response.sendRedirect("cart.jsp");
//                        }
//                    }
//                }
//                if (action.equals("dec")) {
//                    for (Cart c : cart_list) {
//                        if (c.getId() == id && c.getQuantity() > 1) {
//                            int quantity = c.getQuantity();
//                            quantity--;
//                            c.setQuantity(quantity);
//                            break;
//                        }
//                    }
//                    response.sendRedirect("cart.jsp");
//                }
//            } else {
//                response.sendRedirect("cart.jsp");
//            }
//        }
//
//
//    }


}
