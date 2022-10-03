package com.api.Sewing_System.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

// Attributes <------------------------

    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    
    @Column(nullable = false)
    private String password;

// Foreign Keys <----------------------

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Column(name = "historicid_id")
    @JsonProperty("historic")
    private List<Historic> historic = new ArrayList<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Column(name = "cart_id")
    @JsonProperty("cart")
    private List<Cart> cart = new ArrayList<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Column(name = "favorite_id")
    @JsonProperty("favorites")
    private List<Favorites> favorites = new ArrayList<>();

// Methods <---------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
