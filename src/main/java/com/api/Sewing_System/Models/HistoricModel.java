package com.api.Sewing_System.Models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.api.Sewing_System.dtos.HistoricDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_Historic")
public class HistoricModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHistorico;
    
    @Column(nullable = false)
    private LocalDateTime dataCompra;
    
    @Column(nullable = false)
    private int quantidade;
    
    @ManyToOne
    @JsonIgnore
    private ClientModel client;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fk_Historico")
    private List<DiscountsModel> fk_Discontos;

    public HistoricModel(HistoricDto dto, ClientModel client) {
        this.dataCompra = LocalDateTime.now();
        this.quantidade = dto.getQuantidade();
        this.client = client;
    }

    public HistoricModel() {
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public Long getIdHistoric() {
        return idHistorico;
    }

    public void setIdHistoric(Long idHistorico) {
        this.idHistorico = idHistorico;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}