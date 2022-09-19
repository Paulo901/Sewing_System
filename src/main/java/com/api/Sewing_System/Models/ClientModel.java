package com.api.Sewing_System.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "TB_Client")
public class ClientModel implements Serializable {
    private static long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
    @Column(nullable = false, length = 100)
    private String clnome;
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    @Column(nullable = false)
    private String senha;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Column(name = "historicid_id")
    @JsonProperty("historicModel")
    private List<HistoricModel> historic = new ArrayList<>();


    public UUID getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(UUID idCliente) {
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
    public List<HistoricModel> getHistoric() {
        return historic;
    }
    public void setHistoric(List<HistoricModel> historic) {
        this.historic = historic;
    }
}
