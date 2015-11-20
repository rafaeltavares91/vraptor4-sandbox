package br.ufrn.modelo.dao.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ufrn.modelo.dao.UsuarioDao;
import br.ufrn.modelo.dominio.Usuario;

@RequestScoped
public class UsuarioJpaDao extends JpaDao<Usuario> implements UsuarioDao {

	@Inject
	public UsuarioJpaDao(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public boolean possuiPermissaoLogar(Usuario usuario) {
		boolean possuiPermissao = false;
		Query query = entityManager.createQuery("from Usuario u "
				+ "where u.login = :login and u.senha = :senha");
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		if (query.getResultList().size() > 0) {
			possuiPermissao = true;
		}
		return possuiPermissao;
	}

	@Override
	public Usuario buscarPorLogin(Usuario usuario) {
		Query query = entityManager.createQuery("from Usuario u where u.login = :login");
		query.setParameter("login", usuario.getLogin());
		return (Usuario) query.getSingleResult();
	}
	
}
