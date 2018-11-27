package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.DisciplinaEntity;
import br.unipe.jacademy.repositories.IDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService extends GenericService<DisciplinaEntity, IDisciplinaRepository> {

    @Autowired
    protected DisciplinaService(IDisciplinaRepository repository) {
        super(repository);
    }
}