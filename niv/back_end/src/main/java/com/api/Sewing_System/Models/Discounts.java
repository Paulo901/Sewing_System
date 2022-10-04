package com.api.Sewing_System.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;


@Entity
@Table(name = "TB_DISCOUNTS")
public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

// Attributes <------------------------

    @Column(nullable = false)
    private String discountType;

    @Column(nullable = false)
    private Double discountValue;

    @Column(nullable = false)
    private String discountAccessKey;

// Foreign Keys <----------------------

    @ManyToOne
    @JsonIgnore
    private Historic historic;

// Methods <---------------------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public String getDiscountAccessKey() {
        return discountAccessKey;
    }

    public void setDiscountAccessKey(String discountAccessKey) {
        this.discountAccessKey = discountAccessKey;
    }

    public Historic getHistoric() {
        return historic;
    }

    public void setHistoric(Historic historic) {
        this.historic = historic;
    }
}
