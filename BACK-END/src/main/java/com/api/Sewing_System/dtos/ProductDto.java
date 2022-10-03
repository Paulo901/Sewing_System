package com.api.Sewing_System.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDto {

    @NotBlank
    @NotNull
    private String item;

    @NotNull
    private Double price;

    @NotBlank
    @NotNull
    private String image;
    //deve receber um link

// Methods <---------------------------


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
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
}