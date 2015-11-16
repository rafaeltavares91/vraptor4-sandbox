package br.edu.unirn.controlador;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.unirn.anotacoes.Transacional;
import br.edu.unirn.modelo.dao.CompraDao;
import br.edu.unirn.modelo.dao.ProdutoDao;
import br.edu.unirn.modelo.entidade.Compra;

@Controller
public class CompraController {

	private Result result;
	private CompraDao dao;
	private ProdutoDao produtoDao;
	
	@Inject
	public CompraController(Result result, CompraDao dao, ProdutoDao produtoDao){
		this.result = result;
		this.dao = dao;
		this.produtoDao = produtoDao;
	}
	
	public CompraController () {
		this(null, null, null);
	}
	
	@Get
	public void listar() {
		List<Compra> compraList = dao.listarTodos();
		result.use(Results.json()).withoutRoot().from(compraList).recursive().serialize();
    }
	
	@Path("/compra/comprar/{produtoId}")
	@Get
	@Transacional
	public void comprar(String produtoId) {
		Compra compra = new Compra();
		compra.setProduto(produtoDao.buscar(Long.valueOf(produtoId)));
		dao.salvar(compra);
		result.redirectTo(InicioController.class).index();
	}
}
