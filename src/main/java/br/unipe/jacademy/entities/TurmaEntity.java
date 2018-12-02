package br.unipe.jacademy.entities;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    private String nome;
    private Calendar horario;

	public Set<AlunoEntity> getAlunos() {
		return alunos;
	}
	public void setAlunos(Set<AlunoEntity> alunos) {
		this.alunos = alunos;
	}
	public DisciplinaEntity getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaEntity disciplina) {
		this.disciplina = disciplina;
	}
	public ProfessorEntity getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorEntity professor) {
		this.professor = professor;
	}
	public SalaEntity getSala() {
		return sala;
	}
	public void setSala(SalaEntity sala) {
		this.sala = sala;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getHorario() {
		return horario;
	}
	public void setHorario(Calendar horario) {
		this.horario = horario;
	}

    
}
