package com.api.Sewing_System.dtos;

import com.api.Sewing_System.Models.ClientModel;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class HistoricDto {

//    @NotBlank
//    private LocalDateTime dataCompra;
    @NotNull
    private int quantidade;
    @NotNull
    private ClientModel fk_Clente;

    public ClientModel getFk_Clente(){ return fk_Clente; }
    public void setFk_Clente(ClientModel fk_Clente) { this.fk_Clente = fk_Clente; }
//    public LocalDateTime getDataCompra(){ return dataCompra; }
//    public void setDataCompra(LocalDateTime dataCompra) { this.dataCompra = dataCompra; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
