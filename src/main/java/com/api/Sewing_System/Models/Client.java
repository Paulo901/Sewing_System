package com.api.Sewing_System.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCliente;

    // Attributes <------------------------

    @Column(nullable = false, length = 100)
    private String clnome;
    
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    
    @Column(nullable = false)
    private String senha;

    // Foreign Keys <----------------------

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Column(name = "historicid_id")
    @JsonProperty("historic")
    private List<Historic> historic = new ArrayList<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Column(name = "cart_id")
    @JsonProperty("cart")
    private List<Cart> cart = new ArrayList<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Column(name = "favorite_id")
    @JsonProperty("favorites")
    private List<Favorites> favorites = new ArrayList<>();

    // Methods <---------------------------

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getClnome() {
        return clnome;
    }

    public void setClnome(String clnome) {
        this.clnome = clnome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Historic> getHistoric() {
        return historic;
    }

    public void setHistoric(Historic historic) {
        this.historic.add(historic);
    }
}
