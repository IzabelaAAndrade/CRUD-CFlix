package com.crudcflix.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Ator {

    @Id
    @NotBlank
    private String cpf;
    @NotBlank
    private String nome;
    @NotBlank
    private Date dt_nascimento;
    @NotBlank
    private String local_residencia;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getLocal_residencia() {
        return local_residencia;
    }

    public void setLocal_residencia(String local_residencia) {
        this.local_residencia = local_residencia;
    }
}
