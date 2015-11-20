package br.ufrn.modelo.dao;

import br.ufrn.modelo.dominio.Usuario;

public interface UsuarioDao extends Dao<Usuario> {

	boolean possuiPermissaoLogar(Usuario usuario);

	Usuario buscarPorLogin(Usuario usuario);

}
