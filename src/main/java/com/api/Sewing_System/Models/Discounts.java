package com.api.Sewing_System.Models;

import com.api.Sewing_System.Properties.discounts.DiscountType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DISCOUNTS")
public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

// Attributes <------------------------

    @Column(nullable = false, length = 100)
    private DiscountType discountType;
    
    @Column(nullable = false)
    private double value;
    
    @Column(nullable = false)
    private String accessKey;

// Foreign Keys <----------------------

    @ManyToOne
    @JsonIgnore
    private Historic historic;

// Methods <---------------------------


}
