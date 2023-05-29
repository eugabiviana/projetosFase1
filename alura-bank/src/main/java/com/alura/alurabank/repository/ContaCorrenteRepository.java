package com.alura.alurabank.repository;

import com.alura.alurabank.dominio.ContaCorrente;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
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

    public Optional<ContaCorrente> buscar(String banco, String agencia, String numero){
        return contas.stream()
                .filter(contaCorrente -> contaCorrente.identificadaPor(banco, agencia, numero))
                .findFirst();
    }

    public void fechar(ContaCorrente contaCorrente) {
        contas.remove(contaCorrente);
    }
}

/* COMENTÁRIOS:
- Essas annotations no início das classes, são para o Spring INSTANCIAR (criar) as classes para nós.
- Optional: retorna SE encontrar o parâmetro passado;
- findFirst: retorna a primeira ocorrência encontrada com o parâmetro passado;
 */
