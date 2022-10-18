package com.ecommerceWeek7.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Long userid;

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
    @Enumerated(EnumType.STRING)
    private Roles role;



    //Admin constructor


    public User(String firstName, String lastName, String userName, String email, String password, Roles role) {
        this.firstName = firstName;
        LastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    //Customer constructor


//    public User(String firstName, String lastName, String userName, String email, String password, Roles role) {
//        this.firstName = firstName;
//        LastName = lastName;
//        this.userName = userName;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//
//    }
}
