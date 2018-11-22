package br.unipe.jacademy.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Disciplinas")
public class DisciplinaEntity extends GenericEntity {
    private static final long serialVersionUID = 3L;

    @OneToMany(mappedBy = "disciplina")
    private Set<TurmaEntity> turmas;

    private String nome;
    private float nota1;
    private float nota2;
    private float nota3;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }
}