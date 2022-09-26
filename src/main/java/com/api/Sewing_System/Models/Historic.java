package com.api.Sewing_System.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.api.Sewing_System.Properties.product.ProductDetails;
import com.api.Sewing_System.dtos.HistoricDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_HISTORIC")
public class Historic {

    public Historic(HistoricDto dto, Client client, ProductDetails productDetails) {
        this.productDetails = productDetails;
        this.purchaseDate = LocalDateTime.now();
        this.client = client;
    }

    public Historic() {
    }
// ------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

// Attributes <------------------------

    @Column(nullable = false)
    private LocalDateTime purchaseDate;
    
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private ProductDetails productDetails;


// Foreign Keys <----------------------

    @ManyToOne
    @JsonIgnore
    private Client client;
    
    @OneToMany(mappedBy = "historic", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Column(name = "discount_id")
    @JsonProperty("discount")
    private List<Discounts> discounts = new ArrayList<>();

    @OneToMany(mappedBy = "historic", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Column(name = "product_id")
    @JsonProperty("product")
    private List<Products> product = new ArrayList<>();

// Methods <---------------------------

}