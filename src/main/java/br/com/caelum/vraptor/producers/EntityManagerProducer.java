package br.com.caelum.vraptor.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.util.JPAUtil;

public class EntityManagerProducer {
	
	//mostra para o CDI como criar um EntityManager
	
	@Produces
	@RequestScoped //tempo de vida do objeto
	public EntityManager criaEntityManager(){
		//quando subir a aplicação o CDI procura as classes que contém o @Produces e
		//quando alguem pedir um EntityManager, sabe que vai ser esse o método chamando
		return JPAUtil.criaEntityManager();
	}

}
