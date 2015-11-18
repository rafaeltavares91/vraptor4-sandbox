package br.ufrn.fabrica;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class FabricaJPA {

	@Produces
	@ApplicationScoped
	public EntityManagerFactory criaEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("default");
	}
	
	@Produces
	@RequestScoped
	public EntityManager criaEntityManager(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}
	
	public void fechaEntityManagerFactory(@Disposes EntityManagerFactory factory) {
		factory.close();
	}
	
	public void fechaEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}
