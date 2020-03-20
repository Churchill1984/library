package com.eng.it.db;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RequestScoped
public class ApplicationResources {

	private EntityManager entityManager;

    @Produces
    public EntityManager getEntityManager() {
        if(entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("primary");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }
}
