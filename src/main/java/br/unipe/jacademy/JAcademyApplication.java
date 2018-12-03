package br.unipe.jacademy;

import br.unipe.jacademy.entities.SalaEntity;
import br.unipe.jacademy.repositories.ISalaRepository;
import br.unipe.jacademy.repositories.ITurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class JAcademyApplication implements CommandLineRunner {

    @Autowired
    private ISalaRepository salaRepositorory;
    @Autowired
    private ITurmaRepository turmaRepository;

    public static void main(String[] args) {
        SpringApplication.run(JAcademyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

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
