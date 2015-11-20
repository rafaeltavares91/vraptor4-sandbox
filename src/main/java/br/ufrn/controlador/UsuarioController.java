package br.ufrn.controlador;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.ufrn.anotacoes.Transacional;
import br.ufrn.mensagem.MensagemSucesso;
import br.ufrn.modelo.dao.UsuarioDao;
import br.ufrn.modelo.dominio.Usuario;

@Controller
public class UsuarioController {

	private Result result;
	private UsuarioDao dao;
	
	@Inject
	public UsuarioController(Result result, UsuarioDao dao){
		this.result = result;
		this.dao = dao;
	}
	
	public UsuarioController(){
		this(null, null);
	}
	
	public void form(){
	}
	
	@Transacional
	public void salvar(Usuario usuario){
		dao.salvar(usuario);
		MensagemSucesso mensagem = new MensagemSucesso("mensagem.sucesso.descricao");
		result.include(mensagem);
		result.redirectTo(this).lista();
	}
	
	@Get
	public void lista() {
		List<Usuario> usuarioList = dao.listarTodos();
		result.include("usuarioList", usuarioList);
	}
	
	@Get
	public void listar() {
		List<Usuario> usuarioList = dao.listarTodos();
		result.use(Results.json()).from(usuarioList).recursive().serialize();
    }
	
	@Transacional
	public void editar(Long id) {
		Usuario usuario = dao.buscar(id);
		result.include(usuario);
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
