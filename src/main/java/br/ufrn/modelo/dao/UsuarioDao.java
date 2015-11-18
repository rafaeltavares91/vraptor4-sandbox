package br.ufrn.modelo.dao;

import br.ufrn.modelo.entidade.Usuario;

public interface UsuarioDao extends Dao<Usuario> {

	boolean possuiPermissaoLogar(Usuario usuario);

}