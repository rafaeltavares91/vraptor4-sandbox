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
import br.ufrn.modelo.dominio.Categoria;

@Controller
public class CategoriaController {

	private Result result;
	private CategoriaDao dao;
	private Validator validator;
	
	@Inject
	public CategoriaController (Result result, CategoriaDao dao, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}
	
	public CategoriaController () {
		this(null, null, null);
	}
	
	public void form(){
	}
	
	@Transacional
	public void salvar(Categoria categoria){
		validator.validate(categoria);
		if (validator.hasErrors()) {
			validator.onErrorRedirectTo(this).form();
		}

		dao.salvar(categoria);
		MensagemSucesso mensagem = new MensagemSucesso("mensagem.sucesso.descricao");
		result.include(mensagem);
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
	
	public void editar(Long id) {
		Categoria categoria = dao.buscar(id);
		result.include(categoria);
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
