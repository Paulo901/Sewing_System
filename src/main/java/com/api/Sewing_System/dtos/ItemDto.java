package com.api.Sewing_System.dtos;

import com.api.Sewing_System.Models.HistoricModel;
import javax.validation.constraints.NotBlank;

public class ItemDto {

    @NotBlank
    private String item;
    @NotBlank
    private String quantidadeTotal;
    @NotBlank
    private double preco;
    @NotBlank
    private HistoricModel fk_Historic;

    public String getItem() {return item;}
    public void setItem(String item) {this.item = item;}
    public String getQuantidadeTotal() {
        return quantidadeTotal;}
    public void setQuantidadeTotal(String quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;}
    public double getPreco() {return preco;}
    public void setPreco(double preco) {this.preco = preco;}
    public HistoricModel getFk_Historic() {
        return fk_Historic;}
    public void setFk_Historic(HistoricModel fk_Historic) {
        this.fk_Historic = fk_Historic;}
}