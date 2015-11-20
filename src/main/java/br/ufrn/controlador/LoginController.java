package br.ufrn.controlador;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.ufrn.mensagem.Mensagem;
import br.ufrn.mensagem.MensagemErro;
import br.ufrn.modelo.dao.UsuarioDao;
import br.ufrn.modelo.dominio.DadosSessao;
import br.ufrn.modelo.dominio.Usuario;

@Controller
public class LoginController {

	private Result result;
	private UsuarioDao usuarioDao;
	private DadosSessao dadosSessao;
	private static final int TRES_HORAS = 10800;
	
	@Inject
	public LoginController(Result result, UsuarioDao usuarioDao, DadosSessao dadosSessao){
		this.result = result;
		this.usuarioDao = usuarioDao;
		this.dadosSessao = dadosSessao;
	}
	
	public LoginController() {
		this(null, null, null);
	}
	
	@Path("/")
	public void login() {
	}
	
	public void logar (Usuario usuario) {
		Usuario usuarioLogado = usuarioDao.buscarUsuario(usuario);
		if (usuarioLogado != null) {
			dadosSessao.setUsuarioLogado(usuarioLogado);
			dadosSessao.setTempoSessao(TRES_HORAS);
			result.redirectTo(InicioController.class).index();
		} else {
			Mensagem mensagem = new MensagemErro("mensagem.erro.logar");
			result.include(mensagem);
			result.redirectTo(this).login();
		}
	}

	private boolean checarRoot(Usuario usuario) {
		boolean possuiPermissao = false;
		if (usuario.getLogin().equals("root") && usuario.getSenha().equals("123456")) {
			possuiPermissao = true;
		}
		return possuiPermissao;
	}
}
