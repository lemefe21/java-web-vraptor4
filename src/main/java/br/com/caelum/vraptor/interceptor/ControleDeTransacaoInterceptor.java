package br.com.caelum.vraptor.interceptor;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.AfterCall;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;

@Intercepts(after=AutorizadorInterceptor.class)
public class ControleDeTransacaoInterceptor {
	
	//ordenei para que sejá executado somente depois do autorizador
	
	@Inject private EntityManager em;
	
	@BeforeCall
	public void before(){
		System.out.println("Interceptor Transaction Before *************");
		em.getTransaction().begin();
	}
	
	@AfterCall
	public void after(){
		System.out.println("Interceptor Transaction After **************");
		em.getTransaction().commit();
	}
	
	//implementação de rollback com @AroundCall

}
