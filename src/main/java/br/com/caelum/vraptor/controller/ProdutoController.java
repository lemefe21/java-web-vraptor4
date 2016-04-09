package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {
	
	private final Result result;
	private final ProdutoDao dao;
	private final Validator validator;
	private HttpServletRequest request;
	
	@Deprecated //para evitar sua chamada, uso somento do CDI!
	public ProdutoController() {
		//sem argumentos para uso do CDI, onde é criada a primeira instância
		this(null, null, null, null);
	}

	//classe Result injetada
	@Inject
	public ProdutoController(Result result, ProdutoDao dao, Validator validator, HttpServletRequest request) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.request = request;
	}

	@Get("/")
	public void inicio(){
	}
	
	@Get
	public void lista(){
		
		//EntityManager em = JPAUtil.criaEntityManager();
		//ProdutoDao dao = new ProdutoDao(em);
		//passamos a usar injeção de dependencia
		//return dao.lista(); //retorno para view lista.jsp
		
		result.include("produtoList", dao.lista());
		
	}
	
	@Get
	public void listaXML(){
		
		//EntityManager em = JPAUtil.criaEntityManager();
		//ProdutoDao dao = new ProdutoDao(em);
		
		result.use(Results.xml()).from(dao.lista()).serialize();
		
	}
	
	@Get
	public void listaJSON(){
		
		//EntityManager em = JPAUtil.criaEntityManager();
		//ProdutoDao dao = new ProdutoDao(em);
		
		result.use(Results.json()).from(dao.lista()).serialize();
		
	}
	
	@Get
	public void formulario(){
		
	}
	
	@Post
	public void adiciona(@Valid Produto produto){
		
		System.out.println("Produto: " + produto.getNome());
		System.out.println( "Character Encoding " + request.getCharacterEncoding() );
		
		//vai ler a mensagem de erro do ValidationMessages.properties
		//validator.check(produto.getNome().trim().length() > 0, 
				//new I18nMessage("produto.nome", "nome.vazio.caracteres"));
		
		validaCampoNomeProdutoEspacos(produto);
		
		//se houver algum erro é direcionado para o formulário para mostrar o erro
		//utilizando o bean validation
		validator.onErrorForwardTo(this).formulario();
		
		//muito acoplamento...
		/*EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		em.getTransaction().begin();
		dao.adiciona(produto);
		em.getTransaction().commit();*/
		
		dao.adiciona(produto);
		
		//result.forwardTo(this).lista();
		//executa novamente a mesma requisicao
		
		result.include("mensagem", "Produto adicionado com sucesso!");
		result.redirectTo(this).lista();
	
	}
	
	private void validaCampoNomeProdutoEspacos(Produto produto) {
		
		System.out.println("Produto: " + produto.getNome()	);
		
		if(produto.getNome() != null){
			validator.check(produto.getNome().trim().length() > 0, 
					new I18nMessage("produto.nome", "nome.vazio.espacos"));
		}
		
	}

	@Delete
	public void remove(Produto produto){
		
		System.out.println("Produto removido: " + produto.getId()); //null
		
		/*EntityManager em = JPAUtil.criaEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		em.getTransaction().begin();
		dao.remove(produto);
		em.getTransaction().commit();*/
		
		dao.remove(produto);
		
		result.include("removido", "Produto removido com sucesso!");
		result.redirectTo(this).lista();
		
	}

}
