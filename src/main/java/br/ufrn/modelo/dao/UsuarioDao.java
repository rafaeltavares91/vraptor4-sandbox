package br.ufrn.modelo.dao;

import br.ufrn.modelo.dominio.Usuario;

public interface UsuarioDao extends Dao<Usuario> {

	Usuario buscarUsuario(Usuario usuario);

}
