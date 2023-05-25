package com.alura.alurabank.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ContaCorrente {

    @JsonProperty
    private String banco;
    @JsonProperty
    private String agencia;
    @JsonProperty
    private String numero;
    @JsonProperty
    private BigDecimal saldo;
    @JsonIgnore
    private Correntista correntista;

    public ContaCorrente(String banco, String agencia, String numero, Correntista correntista){
        this();
        this.agencia = agencia;
        this.banco = banco;
        this.numero = numero;
        this.correntista = correntista;
    }

    public ContaCorrente() {
        this.saldo = BigDecimal.ZERO;
    }

    public int obterNumeroConta(){
        return Integer.parseInt(numero);
    }

    public boolean identificadaPor(String banco, String agencia, String numero){
        return this.banco.equals(banco)
                && this.agencia.equals(agencia)
                && this.numero.equals(numero);
    }

    public BigDecimal lersaldo() {
        return saldo;
    }

    public void executar( Operacao operacao, BigDecimal valor){
        saldo = operacao.executar(saldo, valor);
    }

    public String getBanco() {
        return banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }
}

/* COMENTÁRIOS:
-  BigDecimal.ZERO: É para que todas as contas sejam criadas com saldo zero e não saldo nulo;
- Esse boolean/equals verifica se o dado passado é o mesmo que consta no banco. Serve para verificar a existência de uma
conta e retornar o dado. Se os dados passados não forem encontrados, o método retornará falso.
- this(); -> refere-se ao construtor de baixo sem argumentos! Que é sobre criar uma conta corrente sem parametro nenhum,
onde o saldo será iniciado com zero.
 */
