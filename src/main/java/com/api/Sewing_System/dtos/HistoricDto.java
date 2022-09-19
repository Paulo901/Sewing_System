package com.api.Sewing_System.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public class HistoricDto {
    @NotNull
    private int quantidade;
    @NotNull
    private UUID fk_Cliente;

    public UUID getFk_Cliente(){ return fk_Cliente; }
    public void setFk_Cliente(UUID fk_Cliente) { this.fk_Cliente = fk_Cliente; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
