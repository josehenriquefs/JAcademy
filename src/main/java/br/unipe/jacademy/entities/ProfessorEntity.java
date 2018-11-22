package br.unipe.jacademy.entities;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Professores")
public class ProfessorEntity extends PessoaEntity {
    private static final long serialVersionUID = 6L;

    @OneToMany(mappedBy = "professor")
    private Set<TurmaEntity> turmas;
}
