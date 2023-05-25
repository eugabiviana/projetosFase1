package com.alura.alurabank.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class MovimentacaoDeConta {

    @JsonProperty //corrige o erro 406! Indica ao Spring que cada propriedade dessa é um json
    private ContaCorrente contaCorrente;
    @JsonProperty
    private BigDecimal valor;
    @JsonProperty
    private int operacao;

    public int obterNumeroConta(){

        return contaCorrente.obterNumeroConta();
    }

    public void executarEm(ContaCorrente contaCorrente){
        Operacao operacao = Operacao.values()[this.operacao];
        contaCorrente.executar(operacao,valor);
    }

    public String getBanco() {
        return contaCorrente.getBanco();
    }

    public String getAgencia() {
        return contaCorrente.getAgencia();
    }

    public String getNumero() {
        return contaCorrente.getNumero();
    }
}
