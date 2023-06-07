package com.alura.alurabank.controller.form;

import com.alura.alurabank.dominio.ContaCorrente;
import com.alura.alurabank.dominio.Correntista;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class CorrentistaForm {
//    Classe criada só para leitura do Json na view

    @JsonProperty
    private String cpf;
    @JsonProperty
    @NotNull(message = "O nome do correntista não pode ser nulo!")
    private String nome;

    public Correntista toCorrentista(){
        return new Correntista(cpf, nome);
    }
}
