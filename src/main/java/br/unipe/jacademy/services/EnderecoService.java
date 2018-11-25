package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.EnderecoEntity;
import br.unipe.jacademy.repositories.IEnderecoRepositorory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends GenericService<EnderecoEntity, IEnderecoRepositorory> {

    @Autowired
    protected EnderecoService(IEnderecoRepositorory repository) {
        super(repository);
    }
}
