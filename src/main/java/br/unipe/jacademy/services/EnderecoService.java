package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.EnderecoEntity;
import br.unipe.jacademy.entities.SalaEntity;
import br.unipe.jacademy.repositories.IEnderecoRepositorory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private IEnderecoRepositorory repository;

    public Iterable<EnderecoEntity> getAll() {
        return repository.findAll();
    }

    public Optional<EnderecoEntity> getPorId(Long idsala) {
        return repository.findById(idsala);
    }

    public EnderecoEntity salvar(EnderecoEntity entity) {
        return repository.save(entity);
    }


    public void excluiPorId(Long id){
        repository.deleteById(id);
    }

}
