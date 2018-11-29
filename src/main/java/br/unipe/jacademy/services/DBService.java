package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.*;
import br.unipe.jacademy.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class DBService {

    @Autowired
    private ISalaRepository salaRepositorory;
    @Autowired
    private IAlunoRepository alunoRepository;
    @Autowired
    private IEnderecoRepository enderecoRepository;

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

        for (int i = 0; i != 10; i++) {
            for (int j = 0; j != 3; j++) {
                AlunoEntity alunoEntity = new AlunoEntity();
                alunoEntity.setNome("Nome"+(char) (letra + i) + String.valueOf(j));
                alunoEntity.setSobrenome("Sobrenome"+(char) (letra + i) + String.valueOf(j));
                alunoEntity.setMae("Mãe"+(char) (letra + i) + String.valueOf(j));
                alunoEntity.setPai("Pai"+(char) (letra + i) + String.valueOf(j));
                alunoEntity.setMatricula("15105666720"+(char) (letra + i) + String.valueOf(j));
                alunoEntity.setEmail("email"+(char) (letra + i) + String.valueOf(j)+"@gmail.com");
                alunoEntity.setSenha("123");
                alunoRepository.save(alunoEntity);
            }
        }

        for (int i = 0; i != 10; i++) {
            for (int j = 0; j != 3; j++) {
                EnderecoEntity enderecoEntity = new EnderecoEntity();
                enderecoEntity.setBairro("Bairro"+(char) (letra + i) + String.valueOf(j));
                enderecoEntity.setCep("CEP"+(char) (letra + i) + String.valueOf(j));
                enderecoEntity.setCidade("Cidade"+(char) (letra + i) + String.valueOf(j));
                enderecoEntity.setLogradouro("Logradouro"+(char) (letra + i) + String.valueOf(j));
                enderecoEntity.setNumero("666"+(char) (letra + i) + String.valueOf(j));
                enderecoRepository.save(enderecoEntity);
            }
        }
    }
}
