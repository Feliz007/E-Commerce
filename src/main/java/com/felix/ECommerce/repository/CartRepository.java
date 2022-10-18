package com.ecommerceWeek7.repository;

import com.ecommerceWeek7.model.Cart;
import com.ecommerceWeek7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
