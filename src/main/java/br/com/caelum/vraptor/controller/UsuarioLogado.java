package br.com.caelum.vraptor.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.vraptor.model.Usuario;

@SessionScoped
@Named
public class UsuarioLogado implements Serializable {
	
	//classe que guarda as informações do usuario logado na session
	//@Named objeto fica disponivel para a jsp's sem a necessidade do result.include
	//tempo de vida da classe é o tempo da sessão
	//classe com escopo de sessão => implements Serializable
	
	private static final long serialVersionUID = 1552280536327897862L;
	
	private Usuario usuario;
	
	@Named
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
