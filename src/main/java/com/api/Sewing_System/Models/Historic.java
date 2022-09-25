package com.api.Sewing_System.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.api.Sewing_System.dtos.HistoricDto2;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_HISTORIC")
public class Historic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHistorico;

    // Attributes <------------------------

    @Column(nullable = false)
    private LocalDateTime dataCompra;
    
    @Column(nullable = false)
    private int quantidade;
    /**
     * DEVE SER NOT NULL
     * private  ProductDetails productDetails;
     *
     */

    // Foreign Keys <----------------------

    @ManyToOne
    @JsonIgnore
    private Client client;
    
    @OneToMany(mappedBy = "historic", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Column(name = "discount_id")
    @JsonProperty("discount")
    private List<Discounts> discounts = new ArrayList<>();

    @OneToMany(mappedBy = "historic", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Column(name = "product_id")
    @JsonProperty("product")
    private List<Products> product = new ArrayList<>();

    // Methods <---------------------------

    public Historic(HistoricDto2 dto, Client client) {
        this.dataCompra = LocalDateTime.now();
        this.quantidade = dto.getQuantidade();
        this.client = client;
    }

    public Historic() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getIdHistoric() {
        return idHistorico;
    }

    public void setIdHistoric(Long idHistorico) {
        this.idHistorico = idHistorico;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}