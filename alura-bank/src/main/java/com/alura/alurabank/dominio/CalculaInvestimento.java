package com.alura.alurabank.dominio;

public class CalculaInvestimento {

    private double porcentagemPoupanca = 0.5;
    private double porcentagemFundoDeInvestimento = 1.5;
    private double porcentagemCDI = 1.6;
    Investimento investimento = new Investimento();

    public double calcularPoupanca(Investimento investimento, double valor) {
        double rendimento = valor + (valor * porcentagemPoupanca);
        return rendimento;
    }
}
