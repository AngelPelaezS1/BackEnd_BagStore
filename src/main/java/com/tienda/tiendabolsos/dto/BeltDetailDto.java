package com.tienda.tiendabolsos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeltDetailDto {

    private Long id;
    private String brand;
    private String model;
    private String color;
    private String material;

    private BigDecimal lengthCm;
    private BigDecimal widthCm;

    private String condition; // Enum como string

    private Boolean hasDustbag;
    private Boolean hasBox;

    private BigDecimal listedPrice;
    private BigDecimal discountedPrice;
    private BigDecimal officialPrice;

    private String description;
    private String imageUrl;          // Imagen principal
    private List<String> extraImages; // URLs de imágenes adicionales

    private String availabilityStatus; // Enum como string

}
