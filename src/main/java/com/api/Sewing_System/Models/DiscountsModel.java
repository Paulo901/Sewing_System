package com.api.Sewing_System.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_Discounts")
public class DiscountsModel implements Serializable {
    private static long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idDesconto;
    @Column(nullable = false, length = 100)
    private String tipoDesconto;
    @Column(nullable = false)
    private double valor;
    @Column(nullable = false)
    private String chaveacesso;
//  fk_Conta int not null,


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
