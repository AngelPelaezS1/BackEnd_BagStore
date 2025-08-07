package com.tienda.tiendabolsos.dto;

import com.tienda.tiendabolsos.enums.CartProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {

    private Long itemId;
    private CartProductType type;
    private Long productId;

    private String brand;
    private String model;
    private String imageUrl;
    private BigDecimal price;

    private int quantity;
}
