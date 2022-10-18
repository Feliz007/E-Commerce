package com.ecommerceWeek7.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

    @Entity
    @Table(name = "orderitems")
    public class OrderItem {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "quantity")
        private @NotNull int quantity;

        @Column(name = "price")
        private @NotNull double price;

        @Column(name = "created_date")
        private Date createdDate;

        @ManyToOne
        @JoinColumn(name = "order_id", referencedColumnName = "id")
        private Order order;

        @ManyToOne
        @JoinColumn(name = "product_id", referencedColumnName = "id")
        private Product product;
}
