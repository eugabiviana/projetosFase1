package com.alura.alurabank.controller.form;

import com.alura.alurabank.dominio.ContaCorrente;
import com.alura.alurabank.dominio.Correntista;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class CorrentistaForm {
//    Classe criada só para leitura do Json na view

    @JsonProperty
    @CPF(message = "CPF inválido!")
    @NotNull (message = "O CPF é um campo obrigatório!")
    private String cpf;
    @JsonProperty
    @NotBlank(message = "O nome do correntista não pode ser nulo e não pode estar em branco!")
    private String nome;

    public Correntista toCorrentista(){
        return new Correntista(cpf, nome);
    }
}

/* COMENTÁRIOS:
- @NotBlank para STRING funciona como notNull e notBlank! Assim, não preciso usar as duas anotações.
 */
