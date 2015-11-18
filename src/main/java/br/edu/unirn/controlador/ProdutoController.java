package br.edu.unirn.controlador;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.unirn.anotacoes.Transacional;
import br.edu.unirn.mensagem.MensagemSucesso;
import br.edu.unirn.modelo.dao.CategoriaDao;
import br.edu.unirn.modelo.dao.ProdutoDao;
import br.edu.unirn.modelo.entidade.Categoria;
import br.edu.unirn.modelo.entidade.Produto;

@Controller
public class ProdutoController {

	private Result result;
	private ProdutoDao dao;
	private CategoriaDao categoriaDao;
	
	@Inject
	public ProdutoController(Result result, ProdutoDao dao, CategoriaDao categoriaDao){
		this.result = result;
		this.dao = dao;
		this.categoriaDao = categoriaDao;
	}
	
	public ProdutoController () {
		this(null, null, null);
	}
	
	public void form () {
		List<Categoria> categoriaList = categoriaDao.listarTodos();
		result.include("categoriaList", categoriaList);
	}
	
	@Transacional
	public void salvar (Produto produto) {
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
	
	@Transacional
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
