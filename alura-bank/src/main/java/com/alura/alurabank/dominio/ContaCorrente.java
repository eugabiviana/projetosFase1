package com.alura.alurabank.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContaCorrente {

    @JsonProperty
    private String banco;
    @JsonProperty
    private String agencia;
    @JsonProperty
    private String numero;

    public ContaCorrente(String banco, String agencia, String numero){
        this.agencia = agencia;
        this.banco = banco;
        this.numero = numero;
    }

}
