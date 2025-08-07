package com.tienda.tiendabolsos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBagRequest {

    private String brand;
    private String model;
    private String color;
    private String material;
    private Double widthCm;
    private Double heightCm;

    private String condition; // Enviado como string (enum)
    private String category;  // Enviado como string (enum)
    private Boolean hasDustbag;

    private BigDecimal listedPrice;
    private BigDecimal officialPrice;

    private String description;
}
