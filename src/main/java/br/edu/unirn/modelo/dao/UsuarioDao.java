package br.edu.unirn.modelo.dao;

import br.edu.unirn.commons.dao.Dao;
import br.edu.unirn.modelo.entidade.Usuario;

public interface UsuarioDao extends Dao<Usuario> {

	boolean possuiPermissaoLogar(Usuario usuario);

}
