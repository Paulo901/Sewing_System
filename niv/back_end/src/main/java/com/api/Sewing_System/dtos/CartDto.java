package com.api.Sewing_System.dtos;


import com.api.Sewing_System.Models.ProductDetails;
import com.api.Sewing_System.Models.Products;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CartDto {

    @NotNull
    private ProductDetails productDetails;
//Tem que desfazer a tabela ao fazer a compra(add em historic)

    @NotNull
    private Long product;


    @NotNull
    private Long client;

// Methods <---------------------------


    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }
}
