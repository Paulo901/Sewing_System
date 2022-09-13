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
    private String clnome;
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    @Column(nullable = false)
    private String senha;



    public UUID getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }
    public String getClnome() {
        return clnome;
    }
    public void setClnome(String clNome) {
        this.clnome = clNome;
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
}
