package com.tienda.tiendabolsos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BagDetailDto {

        private Long id;
        private String brand;
        private String model;
        private String color;
        private String material;
        private Double widthCm;
        private Double heightCm;

        private String condition;        // Enum como string
        private String category;         // Enum como string
        private Boolean hasDustbag;

        private BigDecimal listedPrice;
        private BigDecimal discountedPrice; // se gestiona en frontend si != null
        private BigDecimal officialPrice;

        private String description;
        private String imageUrl;         // Imagen principal
        private List<String> extraImages; // Resto de imágenes

        private String availabilityStatus; // Enum como string
}


