package br.unipe.jacademy.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.unipe.jacademy.entities.TurmaEntity;

public interface ITurmaRepository extends IGenericRepository<TurmaEntity> {

	@Query("select t from TurmaEntity t where t.sala.id = ?1")
	public List<TurmaEntity> findTurmaBySala(Long id);
}