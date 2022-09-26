package com.api.Sewing_System.Models;

import com.api.Sewing_System.Properties.product.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TB_PRODUCT")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

// Attributes <------------------------

    @Column(nullable = false)
    private Item item;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String image;
    //deve receber um link

// Foreign Keys <----------------------

    @ManyToOne
    @JsonIgnore
    private Historic historic;

    @ManyToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Cart> cart = new ArrayList<>();

    @ManyToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Favorites> favorites = new ArrayList<>();

// Methods <---------------------------

}