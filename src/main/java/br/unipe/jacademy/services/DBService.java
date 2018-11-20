package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.*;
import br.unipe.jacademy.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class DBService {

    @Autowired
    private ISalaRepositorory salaRepositorory;

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
    }
}
