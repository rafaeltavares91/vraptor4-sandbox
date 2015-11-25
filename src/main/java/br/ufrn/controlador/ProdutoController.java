package br.ufrn.controlador;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.ufrn.anotacoes.Transacional;
import br.ufrn.mensagem.MensagemSucesso;
import br.ufrn.modelo.dao.CategoriaDao;
import br.ufrn.modelo.dao.ProdutoDao;
import br.ufrn.modelo.dominio.Categoria;
import br.ufrn.modelo.dominio.Produto;

@Controller
public class ProdutoController {

	private Result result;
	private ProdutoDao dao;
	private Validator validator;
	private CategoriaDao categoriaDao;

	@Inject
	public ProdutoController(Result result, ProdutoDao dao, Validator validator, CategoriaDao categoriaDao){
		this.result = result;
		this.dao = dao;
		this.validator = validator;
		this.categoriaDao = categoriaDao;
	}
	
	public ProdutoController () {
		this(null, null, null, null);
	}
	
	public void form () {
		List<Categoria> categoriaList = categoriaDao.listarTodos();
		result.include("categoriaList", categoriaList);
	}
	
	@Transacional
	public void salvar (Produto produto) {
		validator.validate(produto);
		if (validator.hasErrors()) {
			validator.onErrorRedirectTo(this).form();
		}

		if (produto.getCategoria() != null) {
			produto.setCategoria(categoriaDao.buscar(produto.getCategoria().getId()));
			dao.salvar(produto);
			MensagemSucesso mensagem = new MensagemSucesso("mensagem.sucesso.descricao");
			result.include(mensagem);
		}
		result.redirectTo(this).lista();
	}
	
	public void lista() {
		List<Produto> produtoList = dao.listarTodos();
		result.include("produtoList", produtoList);
	}
	
	@Get
	public void listar() {
		List<Produto> produtoList = dao.listarTodos();
		result.use(Results.json()).withoutRoot().from(produtoList).recursive().serialize();
    }
	
	public void editar(Long id) {
		Produto produto = dao.buscar(id);
		result.include(produto);
		result.redirectTo(this).form();
	}
	
	@Transacional
	public void deletar(Long id) {
		dao.deletar(id);
		MensagemSucesso mensagem = new MensagemSucesso("mensagem.remocao.sucesso");
		result.include(mensagem);
		result.redirectTo(this).lista();
	}
}
