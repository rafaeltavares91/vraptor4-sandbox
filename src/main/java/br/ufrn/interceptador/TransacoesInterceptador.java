package br.ufrn.interceptador;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.ufrn.anotacoes.Transacional;

@Intercepts
@AcceptsWithAnnotations(Transacional.class)
public class TransacoesInterceptador {

	private EntityManager entityManager;
	
	@Inject
	public TransacoesInterceptador(EntityManager manager) {
		this.entityManager = manager;
	}

	public TransacoesInterceptador(){
		this(null);
	}
	
	@AroundCall
	public void gerenciarTransacao (SimpleInterceptorStack stack) {
		try {
			entityManager.getTransaction().begin();
			stack.next();
			entityManager.getTransaction().commit();
		} finally {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
		}
	}
}
