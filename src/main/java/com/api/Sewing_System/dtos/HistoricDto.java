package com.api.Sewing_System.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public class HistoricDto {
    @NotNull
    private int quantidade;
    @NotNull
    private UUID client;

    public UUID getCliente(){ return client; }
    public void setCliente(UUID client) { this.client = client; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
