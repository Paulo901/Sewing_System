package com.api.Sewing_System.Models;

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
    @JoinColumn(name = "fk_Cliente", nullable = false)
    private ClientModel fk_Clente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fk_Historico")
    private List<DiscountsModel> fk_Discontos;


    public ClientModel getFk_Clente() { return fk_Clente; }
    public void setFk_Clente(ClientModel fk_Clente) { this.fk_Clente = fk_Clente; }
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
