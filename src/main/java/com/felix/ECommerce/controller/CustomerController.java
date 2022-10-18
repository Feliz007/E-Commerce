package com.ecommerceWeek7.controller;

import com.ecommerceWeek7.dto.UserLoginDTO;
import com.ecommerceWeek7.dto.UserRegistrationDTO;
import com.ecommerceWeek7.model.Product;
import com.ecommerceWeek7.model.User;
import com.ecommerceWeek7.repository.UserRepository;
import com.ecommerceWeek7.services.ProductService;
import com.ecommerceWeek7.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@Controller
public class CustomerController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService service;
    @GetMapping("")
    public String viewHomePage(Model model) {
        List<Product> displayProducts = service.getAll();
        model.addAttribute("displayProducts", displayProducts);
        return "index";
    }
    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signUp";
    }

    @PostMapping("/loading")
    public String processRegister(@ModelAttribute UserRegistrationDTO registrationDto) {
       userService.saveCustomer(registrationDto);
        return "signUpSuccess";
    }

    @GetMapping("/signIn")
    public String showSignInForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/login2")
    public String Signup(@RequestBody UserLoginDTO customer , HttpServletRequest request){

       if( userService.CustomerSignIn(customer).equals("Customer Login successfully")){
           HttpSession session = request.getSession();
            session.setAttribute("newUsers",customer.getEmail());
           return "users";
        }else{
           return "redirect:/signup?User not found";
        }

    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
    @GetMapping("/logout")
    protected String doGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("email");
        session.removeAttribute("password");
        session.invalidate();
        return "/login";
    }
}