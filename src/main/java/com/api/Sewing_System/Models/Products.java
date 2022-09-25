package com.api.Sewing_System.Models;

import com.api.Sewing_System.Properties.TypeProduct;
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

//    @Column(nullable = false, length = 100)
//    private TypeProduct typeProduct;
//
//    @Column(nullable = false, length = 100)
//    private Size size;

    @Column
    private TypeProduct typeProduct;
    @Column(nullable = false)
    private double price;

    @Column
    private String descrição;

    @Column
    private String imagem;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Historic getHistoric() {
        return historic;
    }

    public void setHistoric(Historic historic) {
        this.historic = historic;
    }
}