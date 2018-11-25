package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.SalaEntity;
import br.unipe.jacademy.repositories.ISalaRepositorory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService extends GenericService<SalaEntity, ISalaRepositorory> {

    @Autowired
    protected SalaService(ISalaRepositorory repository) {
        super(repository);
    }

    public List<SalaEntity> getPorNome(String nome){
        return repository.findSalasByName(nome);
    }
}
