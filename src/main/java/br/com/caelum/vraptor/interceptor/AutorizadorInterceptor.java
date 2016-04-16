package br.com.caelum.vraptor.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AfterCall;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.anotacao.Public;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.controller.UsuarioLogado;

@Intercepts
public class AutorizadorInterceptor {

	@Inject private UsuarioLogado usuarioLogado;
	@Inject private Result result;
	
	//classe que contém/segura informações do método que está sendo executado na request
	@Inject private ControllerMethod controllerMethod;

	//intercepta requests

	@Accepts
	public boolean accepts(){
		//vai ou não interceptar uma requisicao
		//intercepta quando "não" tiver a anotação
		return !controllerMethod.containsAnnotation(Public.class);
	}
	

	@AroundCall
	public void intercepta(SimpleInterceptorStack stack){
		
		//antes da execucao
		if(usuarioLogado.getUsuario() == null){
			result.redirectTo(LoginController.class).formulario();
			return;
		}

		System.out.println("Usuário autenticado interceptor: " + usuarioLogado.getUsuario().getNome());
		
		stack.next();

	}
	
	//executado antes de alguma lógica
	@BeforeCall
	public void before(){
		System.out.println("Interceptor Before *************");
	}
	
	@AfterCall
	public void after(){
		System.out.println("Interceptor After **************");
	}
	
	
}
