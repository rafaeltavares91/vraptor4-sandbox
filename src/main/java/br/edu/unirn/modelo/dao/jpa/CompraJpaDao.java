package br.edu.unirn.modelo.dao.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.unirn.commons.dao.JpaDao;
import br.edu.unirn.modelo.dao.CompraDao;
import br.edu.unirn.modelo.entidade.Compra;

@RequestScoped
public class CompraJpaDao extends JpaDao<Compra> implements CompraDao {

	@Inject
	public CompraJpaDao(EntityManager entityManager) {
		super(entityManager);
	}

}
