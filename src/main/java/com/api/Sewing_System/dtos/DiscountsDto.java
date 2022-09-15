package com.api.Sewing_System.dtos;

import com.api.Sewing_System.Models.ClientModel;
import com.api.Sewing_System.Models.HistoricModel;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class DiscountsDto {

    @NotBlank
    @NotNull
    private String tipoDesconto;
    @NotBlank
    @NotNull
    private double valor;
    @NotBlank
    @NotNull
    private String chaveacesso;
    @NotBlank
    @NotNull
    private HistoricModel fk_Historico;

    public String getTipoDesconto() {
        return tipoDesconto;
    }
    public void setTipoDesconto(String tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getChaveacesso() {
        return chaveacesso;
    }
    public void setChaveacesso(String chaveacesso) {
        this.chaveacesso = chaveacesso;
    }
}
