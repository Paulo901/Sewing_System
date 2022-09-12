package com.api.Sewing_System.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_Historic")
public class HistoricModel implements Serializable {
    private static long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idHistorico;
 //   @Column(nullable = false)
 //   private LocalDateTime dataCompra;
    @Column
    private String quantidade;
    //fk_itens int not null,
    //descontos
    //fk_Conta int not null,


    public UUID getIdHistorico() {
        return idHistorico;
    }
    public void setIdHistorico(UUID idHistorico) {
        this.idHistorico = idHistorico;
    }
 //   public LocalDateTime getDataCompra() {
 //       return dataCompra;
 //   }
 //   public void setDataCompra(LocalDateTime dataCompra) {
 //       this.dataCompra = dataCompra;
 //   }
    public String getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
