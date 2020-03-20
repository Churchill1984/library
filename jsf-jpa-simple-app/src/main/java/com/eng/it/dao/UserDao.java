package com.eng.it.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import com.eng.it.model.User;

@RequestScoped
@Named
public class UserDao {

	@Inject
	private EntityManager em;

	public User getUser(String nameUser, String password) {
		String query = "SELECT u from User u where u.nameUser = :name and u.password = :password";

		if (em != null) {
			try {
				User user = (User) em.createQuery(query).setParameter("name", nameUser)
						.setParameter("password", password).getSingleResult();

				return user;
			} catch (NoResultException e) {
				return null;
			}
		} else {
			System.out.println("entity manager je null, ne znam zasto...");
			return null;
		}

	}

	public boolean insertUser(User user) {
		try {
			beginTransaction();
			em.persist(user);
			rollBackTransaction();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(User user) {
		try {
			beginTransaction();
			em.remove(user);
			commitTransaction();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private void beginTransaction() {
		try {
			em.getTransaction().begin();
		} catch (IllegalStateException e) {
			rollBackTransaction();
		}
	}

	private void commitTransaction() {
		try {
			em.getTransaction().commit();
		} catch (IllegalStateException | RollbackException e) {
			rollBackTransaction();
		}
	}

	private void rollBackTransaction() {
		try {
			em.getTransaction().rollback();
		} catch (IllegalStateException | PersistenceException e) {
			e.printStackTrace();
		}
	}
}
