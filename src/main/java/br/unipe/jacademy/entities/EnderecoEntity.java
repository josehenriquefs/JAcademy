package br.unipe.jacademy.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Enderecos")
public class EnderecoEntity<T extends PessoaEntity> extends GenericEntity {
    private static final long serialVersionUID = 4L;

    @ManyToOne
    private SalaEntity sala;

    private String bairro;
    private String cidade;
    private String logradoro;
    private String cep;
    private int numero;

    public SalaEntity getSala() {
        return sala;
    }

    public void setSala(SalaEntity sala) {
        this.sala = sala;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradoro() {
        return logradoro;
    }

    public void setLogradoro(String logradoro) {
        this.logradoro = logradoro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
