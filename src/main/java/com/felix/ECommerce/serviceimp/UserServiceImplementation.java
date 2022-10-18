package com.implementation;

import com.ecommerceWeek7.dto.UserLoginDTO;
import com.ecommerceWeek7.dto.UserRegistrationDTO;
import com.ecommerceWeek7.model.Product;
import com.ecommerceWeek7.model.Roles;
import com.ecommerceWeek7.model.User;
import com.ecommerceWeek7.repository.UserRepository;
import com.ecommerceWeek7.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImplementation implements UserService {

 @Autowired
 private UserRepository userRepository;
 @Autowired
 private  UserRegistrationDTO userRegistrationDTO;

 @Autowired
 private User customer;


    @Override
    public User saveCustomer(UserRegistrationDTO registrationDTO) {
        return userRepository.save(customerDtoToEntity(registrationDTO));
    }

    public User saveAdmin(UserRegistrationDTO registrationDTO) {
        return userRepository.save(adminDtoToEntity(registrationDTO));
    }

    @Override
    public Boolean isFindByCustomerEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user.getRole() == Roles.CUSTOMER){
            if (user == null) {
                return  false;
            }
        }
        return true;
    }

    @Override
    public Boolean isFindByAdminEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user.getRole() == Roles.ADMIN){
            if (user == null) {
                return  false;
            }
        }
        return true;
    }


    @Override
    public Product addProductByAdmin(Product product,User user) {
        return null;
    }

    @Override
    public Product deleteProductByAdmin(Long Id,User user) {
        return null;
    }

    @Override
    public List<User> getAllCustomer() {
        return userRepository.findAll();
    }

    public User customerDtoToEntity(UserRegistrationDTO registrationDTO){

       // User customer = new User();
        customer.setFirstName(registrationDTO.getFirstName());
        customer.setLastName(registrationDTO.getLastName());
        customer.setEmail(registrationDTO.getEmail());
        customer.setUserName(registrationDTO.getUserName());
        customer.setPassword(registrationDTO.getPassword());
        customer.setRole(Roles.CUSTOMER);



        return customer;
    }


    public User adminDtoToEntity(UserRegistrationDTO registrationDTO){
        User admin = new User();
        admin.setFirstName(registrationDTO.getFirstName());
        admin.setLastName(registrationDTO.getLastName());
        admin.setEmail(registrationDTO.getEmail());
        admin.setUserName(registrationDTO.getUserName());
        admin.setPassword(registrationDTO.getPassword());
        admin.setRole(Roles.ADMIN);

        return admin;
    }

    public String CustomerSignIn(UserLoginDTO customer) {
        // first find User by email

        User user = userRepository.findByEmail(customer.getEmail());

        if (user.getRole() == Roles.CUSTOMER) {
            if (!Objects.nonNull(user)) {
                System.out.println("user not present");
                return "User not found";
            }
            // check if password is right
            if (!user.getPassword().equals((customer.getPassword()))) {
                // passwords do not match
                return "Incorrect PassWord";
            }
        }
        return "Customer Login successfully";
    }

    public String AdminSignIn(UserLoginDTO admin) {
        // first find User by email

        User user = userRepository.findByEmail(admin.getEmail());

        if (user.getRole() == Roles.ADMIN) {
            if (!Objects.nonNull(user)) {
                System.out.println("user not present");
                return "User not found";
            }
            // check if password is right
            if (!user.getPassword().equals((admin.getPassword()))) {
                // passwords do not match
                return "Incorrect PassWord";
            }
        }
        return "Admin Login successfully";
    }

}
