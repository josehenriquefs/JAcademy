package br.unipe.jacademy.services;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.jacademy.entities.SalaEntity;
import br.unipe.jacademy.entities.TurmaEntity;
import br.unipe.jacademy.repositories.ISalaRepository;
import br.unipe.jacademy.repositories.ITurmaRepository;

@Service
public class DBService {

    @Autowired
    private ISalaRepository salaRepositorory;
    @Autowired
    private ITurmaRepository turmaRepository;

    public void instantiateTestDatabase() throws ParseException {
        int letra = 'A';

        for (int i = 0; i != 10; i++) {
            for (int j = 0; j != 3; j++) {
                SalaEntity salaEntity = new SalaEntity();
                salaEntity.setNome((char) (letra + i) + String.valueOf(j));
                salaEntity.setDisponibilidade(666 - i);
                salaRepositorory.save(salaEntity);
            }
        }

        /*
        for (int i = 0; i != 10; i++) {
            for (int j = 0; j != 3; j++) {
                TurmaEntity turmaEntity = new TurmaEntity();
                turmaEntity.setNome("Turma "+(char) (letra + i) + String.valueOf(j));
                turmaRepository.save(turmaEntity);
            }
        }
        */
    }
}
