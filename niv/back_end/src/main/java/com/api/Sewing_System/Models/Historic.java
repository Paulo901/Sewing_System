package com.api.Sewing_System.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.api.Sewing_System.Properties.historic.State;
import com.api.Sewing_System.dtos.HistoricDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_HISTORIC")
public class Historic {

    public Historic(HistoricDto dto, Client client, Products product, State state) {
        this.purchaseDate = LocalDateTime.now();
        this.address = dto.getAddress();
        this.state = state;
//        this.discounts;
        this.product = product;
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
    private State state;

//    @Column(nullable = false)
//    private Double totalPay;



// Foreign Keys <----------------------

    @ManyToOne
    private ProductDetails productDetails;

    @ManyToOne
    private Products product;

    @ManyToOne
    @JsonIgnore
    private Client client;
    
    @OneToMany(mappedBy = "historic", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Column(name = "discount_id")
    @JsonProperty("discount")
    private List<Discounts> discounts = new ArrayList<>();

// Methods <---------------------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public double getTotalPay() {
//        return totalPay;
//    }

//    public void setTotalPay(Double totalPay) {
//        this.totalPay = totalPay;
//    }

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

    public List<Discounts> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discounts> discounts) {
        this.discounts = discounts;
    }
}