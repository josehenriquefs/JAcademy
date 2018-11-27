package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.TurmaEntity;
import br.unipe.jacademy.repositories.ITurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService extends GenericService<TurmaEntity, ITurmaRepository> {

    @Autowired
    protected TurmaService(ITurmaRepository repository) {
        super(repository);
    }
}