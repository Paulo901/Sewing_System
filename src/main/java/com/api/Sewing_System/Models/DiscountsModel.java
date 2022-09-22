package com.api.Sewing_System.Models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Discounts")
public class DiscountsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idDesconto;
    
    @Column(nullable = false, length = 100)
    private String tipoDesconto;
    
    @Column(nullable = false)
    private double valor;
    
    @Column(nullable = false)
    private String chaveacesso;
    
    @ManyToOne
    @JoinColumn(name = "fk_Historico", nullable = false)
    private HistoricModel fk_Historico;

    public UUID getIdDesconto() {
        return idDesconto;
    }

    public void setIdDesconto(UUID idDesconto) {
        this.idDesconto = idDesconto;
    }

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
