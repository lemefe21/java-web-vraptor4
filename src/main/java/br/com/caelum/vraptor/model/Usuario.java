package br.com.caelum.vraptor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.caelum.vraptor.util.EncodingUtil;

@Entity
public class Usuario {

	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	private String senha;

	public Usuario() {
	}
	
	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = EncodingUtil.setEncodingUTF8(nome);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = EncodingUtil.setEncodingUTF8(senha);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}