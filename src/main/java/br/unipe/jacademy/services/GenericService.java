package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.GenericEntity;
import br.unipe.jacademy.repositories.IGenericRepository;

import java.util.Optional;

public abstract class GenericService<E extends GenericEntity, R extends IGenericRepository<E>> {

    protected R repository;

    protected GenericService(R repository) {
        this.repository = repository;
    }

    public Iterable<E> getAll() {
        return repository.findAll();
    }

    public Optional<E> getPorId(Long idsala) {
        return repository.findById(idsala);
    }

    public E salvar(E entity) {
        return repository.save(entity);
    }


    public void excluirPorId(Long id){
        repository.deleteById(id);
    }
}
