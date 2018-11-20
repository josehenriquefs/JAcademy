package br.unipe.jacademy.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Salas")
public class SalaEntity extends GenericEntity {
    private static final long serialVersionUID = 3L;

    private String nome;
    private int disponibilidade;

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
