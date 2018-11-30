package br.unipe.jacademy.services;

import br.unipe.jacademy.entities.PessoaEntity;
import br.unipe.jacademy.repositories.IPessoaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public abstract class PessoaService<Pessoa extends PessoaEntity, Repository extends IPessoaRepository<Pessoa>> extends GenericService<Pessoa, Repository> {
    public PessoaService(Repository repository) {
        super(repository);
    }
}
