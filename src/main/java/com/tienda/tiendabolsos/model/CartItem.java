package com.tienda.tiendabolsos.model;

import com.tienda.tiendabolsos.enums.CartProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private CartProductType type;

    private Long productId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
