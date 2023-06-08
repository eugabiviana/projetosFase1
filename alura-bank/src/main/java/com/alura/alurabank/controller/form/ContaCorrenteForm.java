package com.alura.alurabank.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContaCorrenteForm {

    @JsonProperty
    @NotBlank(message = "O número do banco não pode ser nulo e não pode estar em branco!")
    private String banco;
    @JsonProperty
    @NotBlank(message = "O número da agência não pode ser nulo e não pode estar em branco!")
    private String agencia;
    @JsonProperty
    @NotBlank(message = "O número da conta não pode ser nulo e não pode estar em branco!")
    private String numero;

}
