package com.tienda.tiendabolsos.model;

import com.tienda.tiendabolsos.enums.CartProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * El pedido al que pertenece este ítem.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    /**
     * Tipo de producto (BAG o BELT).
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CartProductType type;

    /**
     * ID del producto (puede ser bolso o cinturón).
     * No se enlaza con FK por ser polimórfico.
     */
    @Column(nullable = false)
    private Long productId;

    /**
     * Precio que tenía el producto en el momento de la compra.
     */
    @Column(nullable = false)
    private BigDecimal priceAtPurchase;
}