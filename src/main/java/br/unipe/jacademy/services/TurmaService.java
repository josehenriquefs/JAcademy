package br.unipe.jacademy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.jacademy.entities.TurmaEntity;
import br.unipe.jacademy.repositories.ITurmaRepository;

@Service
public class TurmaService extends GenericService<TurmaEntity, ITurmaRepository> {

    @Autowired
    private TurmaService(ITurmaRepository repository) {
        super(repository);
    }
    
    public List<TurmaEntity> getTurmaPorSala(Long id){
    	return super.repository.findTurmaBySala(id);
    }
}