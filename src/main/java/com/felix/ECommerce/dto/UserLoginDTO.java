package com.ecommerceWeek7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Component
public class UserLoginDTO implements Serializable {

    private String email;
    private String password;
}
