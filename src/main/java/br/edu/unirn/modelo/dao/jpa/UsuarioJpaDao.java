package br.edu.unirn.modelo.dao.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unirn.commons.dao.JpaDao;
import br.edu.unirn.modelo.dao.UsuarioDao;
import br.edu.unirn.modelo.entidade.Usuario;

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
	
}
