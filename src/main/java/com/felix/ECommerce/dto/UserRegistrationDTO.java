package com.ecommerceWeek7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Component
public class UserRegistrationDTO implements Serializable {

    @NotBlank(message = "Full name is required")
    private String firstName;
    @NotBlank(message = "Full name is required")
    private String LastName;

    @NotBlank(message = "Username is required")
    private String userName;

    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
}
