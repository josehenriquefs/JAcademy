package br.unipe.jacademy.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Salas")
public class SalaEntity extends GenericEntity {
    private static final long serialVersionUID = 7L;

    private String nome;
    private int disponibilidade;
    @OneToMany
    private Set<TurmaEntity> turmas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(int disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
