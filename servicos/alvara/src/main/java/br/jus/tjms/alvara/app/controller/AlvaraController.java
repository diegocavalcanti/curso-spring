package br.jus.tjms.alvara.app.controller;

import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.tjms.alvara.infra.service.AlvaraService;
import br.jus.tjms.alvara.model.dto.AlvaraDTO;

@RestController
@RequestMapping("alvara")
public class AlvaraController {

      private final AlvaraService alvaraService;

    public AlvaraController(AlvaraService alvaraServico) {
        this.alvaraService = alvaraServico;
    }

    @GetMapping
    public ResponseEntity<AlvaraDTO> alvara() {
        return ResponseEntity.ok(alvaraService.getAlvara());
    }
}