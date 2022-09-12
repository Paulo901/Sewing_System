package com.api.Sewing_System.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_Client")
public class ClientModel implements Serializable {
    private static long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
    @Column(nullable = false, length = 100)
    private String clNome;
    @Column(nullable = false, unique = true, length = 14)
    private String CPF;
    @Column(nullable = false)
    private String senha;



    public UUID getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }
    public String getClNome() {
        return clNome;
    }
    public void setClNome(String clName) {
        this.clNome = clNome;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
