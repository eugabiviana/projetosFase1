package com.alura.alurabank.controller;

//import com.alura.alurabank.config.JMapperBean;
import com.alura.alurabank.controller.form.ContaCorrenteForm;
import com.alura.alurabank.controller.form.CorrentistaForm;
import com.alura.alurabank.dominio.ContaCorrente;
import com.alura.alurabank.dominio.Correntista;
import com.alura.alurabank.dominio.MovimentacaoDeConta;
import com.alura.alurabank.repository.ContaCorrenteRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contas")
public class ContaCorrenteController {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

//    @Autowired
//    private JMapperBean<ContaCorrente, ContaCorrenteForm> contaCorrenteMapper;
    @GetMapping
    public String consultarSaldo(
            @RequestParam(name = "banco") String banco,
            @RequestParam(name = "agencia") String agencia,
            @RequestParam(name = "numero") String numero){

        ContaCorrente contaCorrente =
                contaCorrenteRepository.buscar(banco, agencia, numero)
                        .orElse(new ContaCorrente());

        return String.format("Banco: %s, Agencia: %s, Numero: %s. Saldo: %s",
                banco, agencia, numero, contaCorrente.lersaldo());
    }

    @PostMapping
    public ResponseEntity criarNovaConta(@RequestBody CorrentistaForm correntistaForm){
        Set<ConstraintViolation<CorrentistaForm>> violacoes =
                Validation.buildDefaultValidatorFactory().getValidator().validate(correntistaForm);
        Map<Path, String> violacoesToMap = violacoes
                .stream()
                .collect(Collectors.toMap(violacao -> violacao.getPropertyPath(), violacao -> violacao.getMessage()));
        if (!violacoesToMap.isEmpty()){
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        Correntista correntista= correntistaForm.toCorrentista();
        String banco = "111";
        String agencia = "2222";
        String numero = Integer.toString(new Random().nextInt(Integer.MAX_VALUE)); //<- para criar números aleatórios.

        ContaCorrente contaCorrente = new ContaCorrente(banco, agencia, numero, correntista);
        contaCorrenteRepository.salvar(contaCorrente);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaCorrente);
    }

//    @DeleteMapping
//    public String fecharConta(@RequestBody ContaCorrenteForm contaCorrenteForm){
//        ContaCorrente contaCorrente = contaCorrenteMapper.contaCorrenteMapper().getDestination(contaCorrenteForm);
//        contaCorrenteRepository.fechar(contaCorrente);
//        return "Conta fechada com sucesso!";
//    }

    @PutMapping
    public ResponseEntity<String> movimentarConta(@RequestBody MovimentacaoDeConta movimentacaoDeConta){
        Optional<ContaCorrente> opContaCorrente =
                contaCorrenteRepository.buscar(movimentacaoDeConta.getBanco(),
                movimentacaoDeConta.getAgencia(),
                movimentacaoDeConta.getNumero());

        if (opContaCorrente.isEmpty()){
            return ResponseEntity.badRequest().body("Conta corrente não existe!");
        } else {
            ContaCorrente contaCorrente = opContaCorrente.get();
            movimentacaoDeConta.executarEm(contaCorrente);
            contaCorrenteRepository.salvar(contaCorrente);
            return ResponseEntity.ok("Movimentação realizada com sucesso!");
        }
    }
}

/* COMENTÁRIOS:
- O que usarei para buscar na URL: http://localhost:8080/contas?banco=888&agencia=1111&numero=3333
- String.format: Possibilita a concatenação sem o sinal de +;
- A annotation @RequestParam serve para o Spring entender/reconhecer que o parametro passado na URL é o mesmo que está
no método consultarSaldo. "É como se fosse um this.algumacoisa";
- A Annotation @RequestBody: o Spring entende que essa informação será criada/passada pelo corpo do programa (ex: quando
passa pelo postman ou pela URL);
- ResponseEntity - é para que eu saiba que a minha conta foi criada com sucesso. Configuro a msg de retorno com o código
e posso mostrar no body as informações da conta que foi criada (passei os parametros da conta nos parênteses de new CC).
- Entendendo o meu post: quando passo nome e cpf de um cliente, ele me retorna uma nova CC!
- Para o método de Delete, mudo os parâmentros, passo os atributos da conta que foi criada, com banco, agencia e numero.
- Usando o curl:
  POST: curl -i -X DELETE http://localhost:8080/contas -H "Content-type: application/json" -d
  '{"banco":"333","agencia":"4444","numero":"1111"}'
  DELETE: curl -i -X DELETE http://localhost:8080/contas -H "Content-type: application/json" -d
  '{"banco":"333","agencia":"4444","numero":"1111"}'
  PUT: curl -i -X PUT http://localhost:8080/contas -H "Content-type: application/json" -d
  '{"valor":"10.00", "operacao":"SAQUE", "contaCorrente": {"banco":"333","agencia":"4444","numero":"1111"}}'
  - orElse no Get: Se não localizar a conta, crio uma nova com o saldo = zero (ver ContaCorrente);
 */