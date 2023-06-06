package com.alura.alurabank.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaCorrente {

    @Setter
    @Getter
    @JsonProperty
    private String banco;
    @Setter
    @Getter
    @JsonProperty
    private String agencia;
    @Setter
    @Getter
    @JsonProperty
    private String numero;
    @JsonProperty
    private BigDecimal saldo;
    @JsonProperty
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaCorrente that = (ContaCorrente) o;
        return Objects.equals(banco, that.banco) && Objects.equals(agencia, that.agencia) && Objects.equals(numero, that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(banco, agencia, numero);
    }

}

/* COMENTÁRIOS:
-  BigDecimal.ZERO: É para que todas as contas sejam criadas com saldo zero e não saldo nulo;
- Esse boolean/equals verifica se o dado passado é o mesmo que consta no banco. Serve para verificar a existência de uma
conta e retornar o dado. Se os dados passados não forem encontrados, o método retornará falso.
- this(); -> refere-se ao construtor de baixo sem argumentos! Que é sobre criar uma conta corrente sem parametro nenhum,
onde o saldo será iniciado com zero.
 */
