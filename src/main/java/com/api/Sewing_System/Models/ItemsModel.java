package com.api.Sewing_System.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_Items")
public class ItemsModel implements Serializable {
    private static long SerialVersionUID = 1L;

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
}