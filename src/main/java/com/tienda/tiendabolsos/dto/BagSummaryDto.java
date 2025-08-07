package com.tienda.tiendabolsos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BagSummaryDto {

    private Long id;
    private String brand;
    private String model;
    private String imageUrl;
    private BigDecimal listedPrice;
    private BigDecimal discountedPrice;
    private boolean showSoldBadge;
}
