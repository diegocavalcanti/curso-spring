package br.jus.tjms.empresa.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.jus.tjms.empresa.infra.exception.RegisterAlteradyExists;
import br.jus.tjms.empresa.infra.repository.EmpresaRepository;
import br.jus.tjms.empresa.model.entity.Empresa;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Transactional
    public Empresa gravar(Empresa empresa) {
        if (empresaRepository.existsByNome(empresa.getNome())) {
            throw new RegisterAlteradyExists("Já existe uma empresa com este nome");
        }

        return empresaRepository.save(empresa);
    }

    public List<Empresa> listar() {
        List<Empresa> empresas = empresaRepository.findAll();
        return empresas;
    }

    public void remover(Long id) {
        Empresa empresaDelete = this.findById(id);
        if (empresaDelete != null)
            empresaRepository.delete(empresaDelete);

    }

    public Empresa findById(Long id) {
        Optional<Empresa> empresaEdit = empresaRepository.findById(id);
        if (empresaEdit.isPresent()) {
            return empresaEdit.get();
        } else {
            return null;
        }

    }

}
