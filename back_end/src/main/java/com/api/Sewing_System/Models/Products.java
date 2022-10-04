package com.api.Sewing_System.Models;

import com.api.Sewing_System.Properties.product.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TB_PRODUCT")
public class Products {

    public Products(Item item) {
        this.item = item;
    }
    public Products() {}


// ------------------------------------
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

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Historic> historic = new ArrayList<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Cart> cart = new ArrayList<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Favorites> favorites = new ArrayList<>();

// Methods <---------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Historic> getHistoric() {
        return historic;
    }

    public void setHistoric(List<Historic> historic) {
        this.historic = historic;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public List<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorites> favorites) {
        this.favorites = favorites;
    }
}