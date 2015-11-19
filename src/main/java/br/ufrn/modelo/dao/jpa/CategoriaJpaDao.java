package br.ufrn.modelo.dao.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ufrn.modelo.dao.CategoriaDao;
import br.ufrn.modelo.dominio.Categoria;

@RequestScoped
public class CategoriaJpaDao extends JpaDao<Categoria> implements CategoriaDao{

	@Inject
	public CategoriaJpaDao(EntityManager entityManager) {
		super(entityManager);
	}

}
