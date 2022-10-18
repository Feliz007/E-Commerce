package com.ecommerceWeek7.model;

import javax.persistence.*;
import java.util.Date;

    @Entity
    @Table(name = "wishlist")
    public class WishList {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
        @JoinColumn(nullable = false, name = "user_id")
        private User user;


        @ManyToOne()
        @JoinColumn(name = "product_id")
        private Product product;
    }
