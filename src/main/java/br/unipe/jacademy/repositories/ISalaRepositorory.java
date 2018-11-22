package br.unipe.jacademy.repositories;

import br.unipe.jacademy.entities.SalaEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISalaRepositorory extends IGenericRepository<SalaEntity>{

    @Query("select s from SalaEntity s where s.nome like %?1%")
    List<SalaEntity> findSalasByName(String nome);
}