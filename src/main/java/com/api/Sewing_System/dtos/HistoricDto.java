package com.api.Sewing_System.dtos;

import javax.validation.constraints.NotNull;

public class HistoricDto {

//    @NotNull
//    private int quantidade;
    //Colocado em ProductDetails
    @NotNull
    private Long client;

// Methods <---------------------------

    public Long getClient(){ return client; }
    public void setClient(Long client) { this.client = client; }

//    public int getQuantidade() { return quantidade; }
//    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

}
