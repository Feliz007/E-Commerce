package com.ecommerceWeek7.controller;

import com.ecommerceWeek7.dto.UserLoginDTO;
import com.ecommerceWeek7.dto.UserRegistrationDTO;
import com.ecommerceWeek7.model.User;
import com.ecommerceWeek7.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
    public class AdminController {
        @Autowired
        private UserService userService;
        @GetMapping("/admin")
        public String viewHomePage(Model model) {
            return "admin/dashboard/index";
        }

        @GetMapping("/1")
        public String showRegistrationForm(Model model) {
            model.addAttribute("user", new User());
            return "signUp2";
        }

        @PostMapping("/1r")
        public String processRegister(UserRegistrationDTO registrationDto) {
            userService.saveAdmin(registrationDto);
            return "signUpSuccess2";
        }

    @PostMapping("/l")
    public String Signup(@RequestBody UserLoginDTO Admin){
        if( userService.AdminSignIn(Admin).equals("Admin Login successfully"));{
            return "users";
        }



    }

}
