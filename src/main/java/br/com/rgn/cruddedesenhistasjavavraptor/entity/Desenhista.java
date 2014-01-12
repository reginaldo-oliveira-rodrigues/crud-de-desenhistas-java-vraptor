package br.com.rgn.cruddedesenhistasjavavraptor.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Desenhista implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message="{nome.obrigatorio}")
	private String nome;
	
	@NotNull(message="{email.obrigatorioevalido}")
	private String email;
	
	@NotNull(message="{site.obrigatorio}")
	private String site;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	public String toString(){
		StringBuilder dadosDoDesenhista = new StringBuilder();
		dadosDoDesenhista.append("Desenhista: ");
		dadosDoDesenhista.append(this.nome);
		dadosDoDesenhista.append("\n");
		dadosDoDesenhista.append("E-mail: ");
		dadosDoDesenhista.append(this.email);
		dadosDoDesenhista.append("\n");
		dadosDoDesenhista.append("Site: ");
		dadosDoDesenhista.append(this.site);
		return dadosDoDesenhista.toString();
	}
}
