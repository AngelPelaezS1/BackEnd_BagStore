package com.tienda.tiendabolsos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BeltImage {

    public BeltImage(String imageUrl, Belt belt) {
        this.imageUrl = imageUrl;
        this.belt = belt;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "belt_id")
    private Belt belt;
}

