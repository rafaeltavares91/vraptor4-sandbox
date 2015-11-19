package br.ufrn.modelo.dao.jpa;

import br.ufrn.modelo.dominio.Entidade;
import br.ufrn.modelo.dao.Dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class JpaDao<T extends Entidade> implements Dao<T> {

	protected final EntityManager entityManager;
	protected final Class<T> clazz;
	
	public JpaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
		Class<T> clazz = inferirTipoGenerico();
		this.clazz = clazz;
	}

	@Override
	public T salvar(T entidade) {
		if (entidade.getId() == null) {
			entityManager.persist(entidade);
		} else {
			entityManager.merge(entidade);
		}
		return entidade;
	}

	@Override
	public T buscar(Long id) {
		return (T) entityManager.find(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listarTodos() {
		Query query = entityManager.createQuery("from " + clazz.getName());
		return query.getResultList();
	}
	
	@Override
	public void deletar(Long id) {
		Entidade entidade = buscar(id);
		entityManager.remove(entidade);
	}
	
	@Override
	public void deletar(T entidade) {
		entityManager.remove(entidade);
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> inferirTipoGenerico() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
