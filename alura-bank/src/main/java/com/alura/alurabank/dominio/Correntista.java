package com.alura.alurabank.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Correntista {

    @JsonProperty
    private String cpf;
    @JsonProperty
    private String nome;

    private LocalDate dataDeEntrada = LocalDate.now();
    public LocalDate getDataDeEntrada() {
        return dataDeEntrada;
    }
}

/*COMENTÁRIOS:
- Para poder deletar os getters dessa classe, coloco a annotation @JsonProperty, pois ela faz com que o postman entenda
como pegar e transformar esses objetos para mostrar as informações.
- Essa é uma classe DTO!
 */