package com.tienda.tiendabolsos.model;

import com.tienda.tiendabolsos.enums.AvailabilityStatus;
import com.tienda.tiendabolsos.enums.Category;
import com.tienda.tiendabolsos.enums.Condition;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    private String color;
    private String material;
    private Double widthCm;  // ancho en centímetros
    private Double heightCm; // alto en centímetros


    @Enumerated(EnumType.STRING)
    private Condition condition;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Boolean hasDustbag;
    private BigDecimal listedPrice;
    private BigDecimal discountedPrice;
    private BigDecimal officialPrice;

    @Lob
    private String description;

    @Column(length = 500)
    private String imageUrl;

    @OneToMany(mappedBy = "bag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BagImage> images = new ArrayList<BagImage>();

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;

    private Boolean available;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime soldAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;
}
