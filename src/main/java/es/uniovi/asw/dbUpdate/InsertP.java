package es.uniovi.asw.dbUpdate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import es.uniovi.asw.logica.User;

public class InsertP implements Insert{

	public void insertarUsuarios(List<User> usuarios) {
		
		EntityManagerFactory emf=Jpa.getEmf();
		EntityManager em = emf.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		try {
			trx.begin();
		} catch (PersistenceException e) {
			
		}

		try {
			
			for(User usuario:usuarios)
			{
				List<User> users=em.createNamedQuery("User.findByNameDni")
						.setParameter(1,usuario.getNIF()).setParameter(2,usuario.getName())
						.getResultList();
				
				if(users.size()==0)
					em.persist(usuario);
			}
			
			trx.commit();
		} catch (RuntimeException bex) {
			trx.rollback();
			System.out.println("Error de las insrciones");
			throw bex;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		System.out.println(trx.isActive());
		System.out.println("Fin de las insercciones en la BD");
	}



}
