package br.unipe.jacademy.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Pessoas")
public abstract class PessoaEntity extends GenericEntity {
    private static final long serialVersionUID = 5L;

    @OneToOne
    private EnderecoEntity endereco;

    private String nome;
    private String sobrenome;
    private String mae;
    private String pai;
    private String matricula;
    private String email;
	public EnderecoEntity getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
