package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {
	
	private final UsuarioDao dao;
	private final Validator validator;
	private final Result result;
	private final UsuarioLogado usuarioLogado;

	@Inject
	public LoginController(UsuarioDao dao, Validator validator, Result result, UsuarioLogado usuarioLogado) {
		this.validator = validator;
		this.dao = dao;
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}
	
	@Deprecated
	public LoginController() {
		this(null, null, null, null);
	}
	
	@Get
	public void formulario(){
		
	}
	
	@Post
	public void autentica(Usuario usuario){
		
		if(!dao.existe(usuario)){
			validator.add(new I18nMessage("login", "login.invalido"));
			//em caso de erro use a pagina do formulario
			validator.onErrorUsePageOf(this).formulario();
		}
		
		usuarioLogado.setUsuario(usuario);
		
		result.redirectTo(ProdutoController.class).lista();
		
	}

}
