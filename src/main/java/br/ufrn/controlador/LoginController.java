package br.ufrn.controlador;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.ufrn.mensagem.MensagemErro;
import br.ufrn.mensagem.MensagemInformacao;
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
		if (usuarioDao.possuiPermissaoLogar(usuario)) {
			Usuario usuariologado = usuarioDao.buscarPorLogin(usuario);
			dadosSessao.setUsuarioLogado(usuariologado);
			dadosSessao.setTempoSessao(TRES_HORAS);
			result.redirectTo(InicioController.class).index();
		} else {
			result.include(new MensagemErro("mensagem.erro.logar"));
			result.redirectTo(this).login();
		}
	}

	public void logout() {
		result.include(new MensagemInformacao("mensagem.logout"));
		dadosSessao.destruir();
		result.of(this).login();
	}
}
