package com.api.Sewing_System.dtos;

import com.api.Sewing_System.Models.Historic;
import javax.validation.constraints.NotBlank;

public class ProductDto {

    @NotBlank
    private String item;
    @NotBlank
    private String quantidadeTotal;
    @NotBlank
    private double preco;
    @NotBlank
    private Historic fk_Historic;

    public String getItem() {return item;}
    public void setItem(String item) {this.item = item;}
    public String getQuantidadeTotal() {
        return quantidadeTotal;}
    public void setQuantidadeTotal(String quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;}
    public double getPreco() {return preco;}
    public void setPreco(double preco) {this.preco = preco;}
    public Historic getFk_Historic() {
        return fk_Historic;}
    public void setFk_Historic(Historic fk_Historic) {
        this.fk_Historic = fk_Historic;}
}