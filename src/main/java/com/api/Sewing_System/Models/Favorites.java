package com.api.Sewing_System.Models;

import com.api.Sewing_System.Properties.product.ProductDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_FAVORITES")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

// Attributes <------------------------

    @Column(nullable = true)
    private ProductDetails productDetails;

// Foreign Keys <----------------------

    @ManyToMany
    private List<Products> product = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private Client client;

// Methods <---------------------------

}
