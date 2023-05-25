package com.alura.alurabank.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class MovimentacaoDeConta {

    @JsonProperty //corrige o erro 406! Indica ao Spring que cada propriedade dessa é um json
    private ContaCorrente contaCorrente;
    @JsonProperty
    private BigDecimal valor;
    @JsonProperty
    private Operacao operacao;

    public int obterNumeroConta(){

        return Integer.parseInt(numero);
    }
}
