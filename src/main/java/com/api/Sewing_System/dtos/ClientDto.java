package com.api.Sewing_System.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClientDto {

    //1 hora e 4 minutos da aula "Spring Boot | Curso Completo 2022

    @NotBlank
    @NotNull
    @Size (max = 100)
    private String clnome;
    @NotBlank
    @NotNull
    @Size(max = 14)
    private String cpf;
    @NotBlank
    @NotNull
    private String senha;



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
}
