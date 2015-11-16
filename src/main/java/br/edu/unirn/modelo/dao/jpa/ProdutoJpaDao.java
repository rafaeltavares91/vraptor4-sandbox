package br.edu.unirn.modelo.dao.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.unirn.commons.dao.JpaDao;
import br.edu.unirn.modelo.dao.ProdutoDao;
import br.edu.unirn.modelo.entidade.Produto;

@RequestScoped
public class ProdutoJpaDao extends JpaDao<Produto> implements ProdutoDao {

	@Inject
	public ProdutoJpaDao(EntityManager entityManager) {
		super(entityManager);
	}

}
