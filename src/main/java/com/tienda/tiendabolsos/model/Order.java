package com.tienda.tiendabolsos.model;


import com.tienda.tiendabolsos.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(optional = false)
        private User buyer;

        @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<OrderItem> items = new ArrayList<>();

        private BigDecimal totalPrice;

        private String shippingAddress;
        private String contactPhone;

        @Enumerated(EnumType.STRING)
        private OrderStatus status; // PENDING, PAID, SHIPPED...

        private LocalDateTime createdAt;
}
