package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.util.JPAUtil;

@Controller
public class ProdutoController {
	
	@Get("/")
	public void inicio(){
	}
	
	@Get
	public List<Produto> lista(){
		
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
		//retorno para view lista.jsp
		return dao.lista();
		
	}
	
	@Get
	public void formulario(){
		
	}
	
	@Post
	public void adiciona(Produto produto){
		
		System.out.println("Produto: " + produto.getNome());
		
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		dao.adiciona(produto);
		em.getTransaction().commit();
	
	}
	
	@Delete
	public void remove(Produto produto){
		
		System.out.println("Produto removido: " + produto.getId()); //null
		
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		dao.remove(produto);
		em.getTransaction().commit();
		
	}

}
