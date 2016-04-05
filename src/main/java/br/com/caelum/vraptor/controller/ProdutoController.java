package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.util.JPAUtil;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {
	
	private final Result result;
	
	public ProdutoController() {
		//sem argumentos para a CDI criar a primeira instancia
		//chama o result null para criar o construtor
		this(null);
	}

	@Inject
	public ProdutoController(Result result) {
		this.result = result;
	}

	@Get("/")
	public void inicio(){
	}
	
	@Get
	public void lista(){
		
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		//return dao.lista(); //retorno para view lista.jsp
		
		result.include("produtoList", dao.lista());
		
	}
	
	@Get
	public void listaXML(){
		
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		result.use(Results.xml()).from(dao.lista()).serialize();
		
	}
	
	@Get
	public void listaJSON(){
		
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		result.use(Results.json()).from(dao.lista()).serialize();
		
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
		
		//result.forwardTo(this).lista(); //executa novamente a mesma requisicao
		
		result.include("mensagem", "Produto adicionado com sucesso!");
		result.redirectTo(this).lista();
	
	}
	
	@Delete
	public void remove(Produto produto){
		
		System.out.println("Produto removido: " + produto.getId()); //null
		
		EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		dao.remove(produto);
		em.getTransaction().commit();
		
		result.include("removido", "Produto removido com sucesso!");
		result.redirectTo(this).lista();
		
	}

}
