package com.alura.alurabank.controller;

import com.alura.alurabank.dominio.ContaCorrente;
import com.alura.alurabank.dominio.Correntista;
import com.alura.alurabank.dominio.MovimentacaoDeConta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaCorrenteController {

    @GetMapping
    public String consultarSaldo(
            @RequestParam(name = "banco") String banco,
            @RequestParam(name = "agencia") String agencia,
            @RequestParam(name = "numero") String numero){
        return String.format("Banco: %s, Agencia: %s, Numero: %s. Saldo: R$1300,00", banco, agencia, numero);
    }

    @PostMapping
    public ResponseEntity<ContaCorrente> criarNovaConta(@RequestBody Correntista correntista){
        ContaCorrente contaCorrente= new ContaCorrente("111","2222", "3333");
        return ResponseEntity.status(HttpStatus.CREATED).body(contaCorrente);
    }

    @DeleteMapping
    public String fecharConta(@RequestBody ContaCorrente contaCorrente){
        return "Conta fechada com sucesso!";
    }

    @PutMapping
    public ResponseEntity<MovimentacaoDeConta> movimentarConta(@RequestBody MovimentacaoDeConta movimentacaoDeConta){
        return ResponseEntity.ok(movimentacaoDeConta);

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
 */