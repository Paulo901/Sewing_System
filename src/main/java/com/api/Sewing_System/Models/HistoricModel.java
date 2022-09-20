package com.api.Sewing_System.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_Historic")
public class HistoricModel implements Serializable {
    private static long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idHistorico;
    @Column(nullable = false)
    private LocalDateTime dataCompra;
    @Column(nullable = false)
    private int quantidade;
    @ManyToOne
    private ClientModel client;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fk_Historico")
    private List<DiscountsModel> fk_Discontos;

    public HistoricModel( ClientModel client){
        //this.quantidade = quantidade;
        this.client = client;
    }
    public HistoricModel(){
    }

    public ClientModel getClient() { return client; }
    public void setClient(ClientModel client) { this.client = client; }
    public UUID getIdHistoric() {
        return idHistorico;
    }
    public void setIdHistoric(UUID idHistorico) {
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