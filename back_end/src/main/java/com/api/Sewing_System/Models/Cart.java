package com.api.Sewing_System.Models;

import com.api.Sewing_System.dtos.CartDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table(name = "TB_CART")
public class Cart {

    public Cart(Client client, Products product) {
        this.inCartDate = inCartDate.now();
        this.product = product;
        this.client = client;
    }

    public Cart() {
    }

// ------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

// Attributes <------------------------

    private LocalDate inCartDate;


// Foreign Keys <----------------------

    @ManyToOne
    private ProductDetails productDetails;

    @ManyToOne
    private Products product;
//Tem que desfazer a tabela ao fazer a compra(add em historic).

    @ManyToOne
    @JsonIgnore
    private Client client;

// Methods <---------------------------

    public Period timeAtCart(){
        Period period = Period.between(inCartDate, LocalDate.now());
        return period;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInCartDate() {
        return inCartDate;
    }

    public void setInCartDate(LocalDate inCartDate) {
        this.inCartDate = inCartDate;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
