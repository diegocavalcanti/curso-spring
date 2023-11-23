package br.jus.tjms.empresa.app.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.tjms.empresa.model.entity.Empresa;
import br.jus.tjms.empresa.model.service.EmpresaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<Empresa> cadastrarEmpresa(@RequestBody  @Valid  Empresa empresa) {
        Empresa retEmpresa = empresaService.gravar(empresa);
        return ResponseEntity.ok(retEmpresa);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> excluirEmpresa(@PathVariable String id) {
        empresaService.remover(Long.parseLong( id ));
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

      

    @GetMapping
    public List<Empresa> listarEmpresas(){
        return empresaService.listar();
    }

    @GetMapping(value = "{id}")
    public Empresa findById(@PathVariable String id){
        return empresaService.findById(Long.parseLong(id));
    }


    
}