package com.alura.alurabank.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContaCorrenteForm {

    @JsonProperty
    private String banco;
    @JsonProperty
    private String agencia;
    @JsonProperty
    private String numero;

}
