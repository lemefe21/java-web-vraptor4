package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.model.Produto;

@RequestScoped
public class ProdutoDao {

	private final EntityManager em;
	
	public ProdutoDao() {
		//sem argumentos para uso do CDI, onde cria a primeira instancia
		this(null);
	}

	@Inject
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void adiciona(Produto produto) {
		//em.getTransaction().begin();
		em.persist(produto);
		//em.getTransaction().commit();
	}

	public void remove(Produto produto) {
		//em.getTransaction().begin();
		em.remove(busca(produto));
		//em.getTransaction().commit();
	}

	public Produto busca(Produto produto) {
		return em.find(Produto.class, produto.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Produto> lista() {
		return em.createQuery("select p from Produto p").getResultList();
	}
}