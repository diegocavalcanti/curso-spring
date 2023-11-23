package br.jus.tjms.alvara.infra.gateway;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.jus.tjms.alvara.model.dto.FuncionarioDTO;


//Aqui é classe responsavel por buscar via client feing no registry
@FeignClient(name = "funcionario-service")
public interface FuncionarioGateway {

    
    @GetMapping("/funcionario/{id}")
    FuncionarioDTO obterFuncionario(@PathVariable  Integer id);




}
