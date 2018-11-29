package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.GenericEntity;
import br.unipe.jacademy.repositories.IGenericRepository;

import java.util.Optional;

public abstract class GenericService<Entity extends GenericEntity, Repository extends IGenericRepository<Entity>> {

    protected Repository repository;

    protected GenericService(Repository repository) {
        this.repository = repository;
    }

    public Iterable<Entity> getAll() {
        return repository.findAll();
    }

    public Optional<Entity> getPorId(Long idsala) {
        return repository.findById(idsala);
    }

    public Entity salvar(Entity entity) {
        return repository.save(entity);
    }


    public void excluirPorId(Long id){
        repository.deleteById(id);
    }
}
