package es.uniovi.asw.dbUpdate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import es.uniovi.asw.logica.User;

public class InsertP implements Insert{

	public void insertarUsuarios(List<User> usuarios) {
		
		
	/*	EntityManager em = Jpa.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		try {
			trx.begin();
		} catch (PersistenceException e) {
			
		}

		try {
			
			for(User usuario:usuarios)
				em.persist(usuario);
			
			trx.commit();
		} catch (RuntimeException bex) {
			trx.rollback();
			throw bex;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

		*/
	}



}
