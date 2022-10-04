package com.api.Sewing_System.Models;

import com.api.Sewing_System.Models.Historic;
import com.api.Sewing_System.Properties.product.Color;
import com.api.Sewing_System.Properties.product.Material;
import com.api.Sewing_System.Properties.product.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_PRODUCT_DETAILS")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Size size;
    private Color color;
    private int amount;
    private Material material;

    @OneToMany(mappedBy = "productDetails", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Column(name = "historic_id")
    @JsonProperty("historic")
    @JsonIgnore
    private List<Historic> historic = new ArrayList<>();

}
