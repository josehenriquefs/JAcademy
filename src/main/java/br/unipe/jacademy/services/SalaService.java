package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.SalaEntity;
import br.unipe.jacademy.repositories.ISalaRepositorory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    @Autowired
    private ISalaRepositorory repository;

    public Iterable<SalaEntity> getAll() {
        return repository.findAll();
    }

    public Optional<SalaEntity> getPorId(Long idsala) {
        return repository.findById(idsala);
    }

    public SalaEntity salvar(SalaEntity entity) {
        return repository.save(entity);
    }


    public void excluiPorId(Long id){
        repository.deleteById(id);
    }

    public List<SalaEntity> getPorNome(String nome){
        return repository.findSalasByName(nome);
    }
}
