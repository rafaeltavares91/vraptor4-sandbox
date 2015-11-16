package br.edu.unirn.controlador;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.unirn.anotacoes.Transacional;
import br.edu.unirn.modelo.dao.CategoriaDao;
import br.edu.unirn.modelo.entidade.Categoria;

@Controller
public class CategoriaController {

	private Result result;
	private CategoriaDao dao;
	
	@Inject
	public CategoriaController (Result result, CategoriaDao dao) {
		this.result = result;
		this.dao = dao;
	}
	
	public CategoriaController () {
		this(null, null);
	}
	
	public void form(){
	}
	
	@Transacional
	public void salvar(Categoria categoria){
		dao.salvar(categoria);
		result.redirectTo(this).lista();
	}
	
	@Get
	public void lista() {
		List<Categoria> categoriaList = dao.listarTodos();
		result.include("categoriaList", categoriaList);
	}
	
	@Get
	public void listar() {
		List<Categoria> categoriaList = dao.listarTodos();
		result.use(Results.json()).withoutRoot().from(categoriaList).recursive().serialize();
    }
	
	@Transacional
	public void editar(Long id) {
		Categoria categoria = dao.buscar(id);
		result.include(categoria);
		result.redirectTo(this).form();
	}
	
	@Transacional
	public void deletar(Long id) {
		dao.deletar(id);
		result.redirectTo(this).lista();
	}
}
