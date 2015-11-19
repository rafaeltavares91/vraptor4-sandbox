package br.ufrn.modelo.dao.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ufrn.modelo.dao.ProdutoDao;
import br.ufrn.modelo.dominio.Produto;

@RequestScoped
public class ProdutoJpaDao extends JpaDao<Produto> implements ProdutoDao {

	@Inject
	public ProdutoJpaDao(EntityManager entityManager) {
		super(entityManager);
	}

}
