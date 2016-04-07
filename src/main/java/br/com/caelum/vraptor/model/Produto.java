package br.com.caelum.vraptor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Produto {

	@GeneratedValue @Id
	private Long id;

	@NotNull(message="{nome.vazio}")
	@Size(min=3, message="{nome.vazio.caracteres}")
	private String nome;
	
	@Min(value=0, message="{valor.negativo}")
	private Double valor;
	
	@Min(value=0, message="{quantidade.negativa}")
	private Integer quantidade;

	public Produto() {
	}
	
	public Produto(String nome, Double valor, Integer quantidade) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

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

	public Double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}