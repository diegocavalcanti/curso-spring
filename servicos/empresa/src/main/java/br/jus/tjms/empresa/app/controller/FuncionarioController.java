package br.jus.tjms.empresa.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.tjms.empresa.app.gateway.AlvaraGateway;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

     private final AlvaraGateway alvaraGateway;

    public FuncionarioController(AlvaraGateway alvaraGateway) {
        this.alvaraGateway = alvaraGateway;
    }

    @GetMapping
    public String obterFuncionario() {
        return "funcionario com " + alvaraGateway.getAlvara();
    }
}
