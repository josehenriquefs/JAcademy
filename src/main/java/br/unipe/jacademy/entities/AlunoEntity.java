package br.unipe.jacademy.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Alunos")
public class AlunoEntity extends PessoaEntity {
    private static final long serialVersionUID = 2L;

    @ManyToMany
    private Set<TurmaEntity> turmas;
}