package br.jus.tjms.alvara.infra.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.jus.tjms.alvara.infra.gateway.FuncionarioGateway;
import br.jus.tjms.alvara.model.dto.AlvaraDTO;
import br.jus.tjms.alvara.model.dto.FuncionarioDTO;

@Service
public class AlvaraService {

    private final FuncionarioGateway funcionarioGateway;

    public AlvaraService(FuncionarioGateway funcionarioGateway) {
        this.funcionarioGateway = funcionarioGateway;
    }

    public AlvaraDTO getAlvara() {
        FuncionarioDTO funcionarioDTO = funcionarioGateway.obterFuncionario(1);
        return new AlvaraDTO(
                UUID.randomUUID(),
                Instant.now(),
                funcionarioDTO.nome());
    }

}
