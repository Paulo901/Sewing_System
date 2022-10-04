package com.api.Sewing_System.dtos;


import com.api.Sewing_System.Models.ProductDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class HistoricDto {

    @NotNull
    @NotBlank
    private String address;

    private String state;

//    @NotNull
    private ProductDetails productDetails;


// Foreign Keys <----------------------

    @NotNull
    private Long client;

    @NotNull
    private List<Long> discounts = new ArrayList<>();

    @NotNull
    private Long product;

// Methods <---------------------------


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Long getOneDiscount(int index) {
        return discounts.get(index);
    }

    public List<Long> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Long> discounts) {
        this.discounts = discounts;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
