package br.jus.tjms.funcionario.app.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

    public FuncionarioController() {

    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> obterFunctionario(
            @PathVariable("id") Integer id) {

        return ResponseEntity.ok(new Funcionario(1, "Raphael"));
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listaFuncionarios() {
        List<Funcionario> funcionarios = List.of(
                new Funcionario(1, "Raphael"),
                new Funcionario(2, "Rafaela"));
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(
            @RequestBody Funcionario funcionario) {
        // Imagina que existe um codigo lindo para salvar este funcionario
        return ResponseEntity.ok(funcionario);
    }

    private record Funcionario(Integer id, String nome) {
    }

}
