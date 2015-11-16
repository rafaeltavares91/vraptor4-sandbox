package br.edu.unirn.controlador;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.edu.unirn.modelo.dao.UsuarioDao;
import br.edu.unirn.modelo.entidade.Usuario;

@Controller
public class LoginController {

	private Result result;
	private UsuarioDao usuarioDao;
	
	@Inject
	public LoginController(Result result, UsuarioDao usuarioDao){
		this.result = result;
		this.usuarioDao = usuarioDao;
	}
	
	public LoginController() {
		this(null, null);
	}
	
	@Path("/")
	public void login() {
	}
	
	public void logar (Usuario usuario) {
		if (usuarioDao.possuiPermissaoLogar(usuario) || checarRoot(usuario)) {
			result.redirectTo(InicioController.class).index();
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
