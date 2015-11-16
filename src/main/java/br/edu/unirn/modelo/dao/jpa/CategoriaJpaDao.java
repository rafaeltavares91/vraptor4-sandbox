package br.edu.unirn.modelo.dao.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.unirn.commons.dao.JpaDao;
import br.edu.unirn.modelo.dao.CategoriaDao;
import br.edu.unirn.modelo.entidade.Categoria;

@RequestScoped
public class CategoriaJpaDao extends JpaDao<Categoria> implements CategoriaDao{

	@Inject
	public CategoriaJpaDao(EntityManager entityManager) {
		super(entityManager);
	}

}
