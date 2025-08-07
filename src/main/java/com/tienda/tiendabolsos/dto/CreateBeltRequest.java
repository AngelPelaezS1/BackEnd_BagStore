package com.tienda.tiendabolsos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBeltRequest {

    private String brand;
    private String model;
    private String color;
    private String material;

    private BigDecimal lengthCm;
    private BigDecimal widthCm;

    private String condition; // Enum como string (NEW, GOOD...)

    private Boolean hasDustbag;
    private Boolean hasBox;

    private BigDecimal listedPrice;
    private BigDecimal officialPrice;

    private String description;
}
