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
public class BagImage {

    public BagImage(String imageUrl, Bag bag) {
        this.imageUrl = imageUrl;
        this.bag = bag;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "bag_id")
    private Bag bag;
}
