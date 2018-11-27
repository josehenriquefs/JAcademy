package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.ProfessorEntity;
import br.unipe.jacademy.repositories.IProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService extends GenericService<ProfessorEntity, IProfessorRepository> {

    @Autowired
    protected ProfessorService(IProfessorRepository repository) {
        super(repository);
    }
}