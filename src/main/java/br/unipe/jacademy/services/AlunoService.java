package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.AlunoEntity;
import br.unipe.jacademy.entities.SalaEntity;
import br.unipe.jacademy.repositories.IAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService extends GenericService<AlunoEntity, IAlunoRepository> {

    @Autowired
    protected AlunoService(IAlunoRepository repository) {
        super(repository);
    }

    public List<SalaEntity> getPorNome(String nome){
        return repository.findAlunosByName(nome);
    }
}