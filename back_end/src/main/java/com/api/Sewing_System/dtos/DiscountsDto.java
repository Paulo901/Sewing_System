package com.api.Sewing_System.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DiscountsDto {

    @NotBlank
    @NotNull
    private String discountType;

    @NotNull
    private Double discountValue;

    @NotBlank
    @NotNull
    private String discountAccessKey;

// Methods <---------------------------


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
}
