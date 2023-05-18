package com.alura.alurabank.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContaCorrente {

    @JsonProperty
    private String banco;
    @JsonProperty
    private String agencia;
    @JsonProperty
    private String numero;
    @JsonIgnore
    private Correntista correntista;

    public ContaCorrente(String banco, String agencia, String numero, Correntista correntista){
        this.agencia = agencia;
        this.banco = banco;
        this.numero = numero;
        this.correntista = correntista;
    }

    public ContaCorrente() {

    }


}
