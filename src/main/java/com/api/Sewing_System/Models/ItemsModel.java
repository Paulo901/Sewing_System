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
@Table(name = "TB_Items")
public class ItemsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idItem;
    
    @Column(nullable = false, length = 100)
    private String item;
    
    @Column(nullable = false)
    private String quantidadeTotal;
    
    @Column(nullable = false)
    private double preco;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private HistoricModel fk_Historic;

    public UUID getIdItem() {
        return idItem;
    }

    public void setIdItem(UUID idItem) {
        this.idItem = idItem;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(String quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public HistoricModel getFk_Historic() {
        return fk_Historic;
    }

    public void setFk_Historic(HistoricModel fk_Historic) {
        this.fk_Historic = fk_Historic;
    }
}