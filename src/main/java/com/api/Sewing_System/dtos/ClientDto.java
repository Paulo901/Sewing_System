package com.api.Sewing_System.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClientDto {

    //1 hora e 4 minutos da aula "Spring Boot | Curso Completo 2022

    @NotBlank
    @Size (max = 100)
    private String clNome;
    @NotBlank
    @Size(max = 14)
    private String CPF;
    @NotBlank
    private String senha;



    public String getClNome() {
        return clNome;
    }
    public void setClNome(String clNome) {
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
