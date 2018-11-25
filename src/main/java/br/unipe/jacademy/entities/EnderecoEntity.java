package br.unipe.jacademy.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Enderecos")
public class EnderecoEntity extends GenericEntity {
    private static final long serialVersionUID = 4L;

    @ManyToOne
    private PessoaEntity pessoa;

    private String bairro;
    private String cidade;
    private String logradoro;
    private String cep;
    private int numero;

    public PessoaEntity getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
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
