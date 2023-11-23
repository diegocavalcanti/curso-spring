package br.jus.tjms.empresa.infra.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.jus.tjms.empresa.model.entity.Empresa;



@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long>  {


    public boolean existsByNome(String nome);

    



    
}
