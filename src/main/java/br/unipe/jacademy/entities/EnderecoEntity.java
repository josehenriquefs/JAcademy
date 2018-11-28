package br.unipe.jacademy.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Enderecos")
public class EnderecoEntity extends GenericEntity {
    private static final long serialVersionUID = 4L;

    @ManyToOne
    private PessoaEntity pessoa;

    private String bairro;
    private String cidade;
    private String logradouro;
    private String cep;
    private String numero;

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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
