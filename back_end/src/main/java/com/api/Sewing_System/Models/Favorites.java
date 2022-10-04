package com.api.Sewing_System.Models;

import com.api.Sewing_System.dtos.CartDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_FAVORITES")
public class Favorites {


    public Favorites(Client client, Products product) {
        this.product = product;
        this.client = client;
    }

    public Favorites() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

// Foreign Keys <----------------------

    @ManyToOne
    private Products product;

    @ManyToOne
    @JsonIgnore
    private Client client;

// Methods <---------------------------

}
