package com.alura.alurabank.repository;

import com.alura.alurabank.dominio.ContaCorrente;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ContaCorrenteRepository {

    private Set<ContaCorrente> contas;
    public ContaCorrenteRepository(){
        contas = new HashSet<>();
    }
    public void salvar(ContaCorrente contaCorrente) {
        contas.add(contaCorrente);
    }
}

/* COMENTÁRIOS:
- Essas annotations no início das classes, são para o Spring INSTANCIAR (criar) as classes para nós.

 */
