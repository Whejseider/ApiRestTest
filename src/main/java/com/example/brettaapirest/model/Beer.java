package com.example.brettaapirest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "beer")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beer_id")
    private Long id;

    @Column(name = "alc")
    private Float alc;

    @Column(name = "category")
    private String category;

    @Column(name = "ibu")
    private Float ibu;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Float price;

}
