package com.api.Sewing_System.dtos;

import javax.validation.constraints.NotNull;

public class HistoricDto2 {
    @NotNull
    private int quantidade;
    @NotNull
    private Long client;

    public Long getClient(){ return client; }
    public void setClient(Long client) { this.client = client; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
