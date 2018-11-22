package br.unipe.jacademy.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Turmas")
public class TurmaEntity extends GenericEntity {
    private static final long serialVersionUID = 8L;

    @ManyToMany
    private Set<AlunoEntity> alunos;

    @ManyToOne
    private DisciplinaEntity disciplina;

    @ManyToOne
    private ProfessorEntity professor;

    @ManyToOne
    private SalaEntity sala;
    private Date horario;

    public SalaEntity getSala() {
        return sala;
    }

    public void setSala(SalaEntity sala) {
        this.sala = sala;
    }
}
