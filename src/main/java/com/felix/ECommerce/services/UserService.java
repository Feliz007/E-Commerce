package com.ecommerceWeek7.services;

import com.ecommerceWeek7.dto.UserLoginDTO;
import com.ecommerceWeek7.dto.UserRegistrationDTO;
import com.ecommerceWeek7.model.Product;
import com.ecommerceWeek7.model.User;

import java.util.List;

public interface UserService {


    public List<User> getAllCustomer();


    public User saveCustomer(UserRegistrationDTO registrationDTO);


    public User saveAdmin(UserRegistrationDTO registrationDTO);


    public Boolean isFindByCustomerEmail(String email);

    public Boolean isFindByAdminEmail(String email);

    Product addProductByAdmin(Product product,User user);

    Product deleteProductByAdmin(Long Id,User user);

    public String CustomerSignIn(UserLoginDTO customer);

    public String AdminSignIn(UserLoginDTO admin);







}
