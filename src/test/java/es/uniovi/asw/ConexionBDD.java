package es.uniovi.asw;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

import es.uniovi.asw.dbUpdate.Jpa;
import es.uniovi.asw.logica.User;

public class ConexionBDD {
	
	private static ConexionBDD conexion;
	
	private ConexionBDD(){
		
	}

	private EntityManager conexion() {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Jpa.getEmf();
			em = emf.createEntityManager();


		} catch (PersistenceException e) {
			System.out.println("No se ha podido conectar con la base de datos");
		}
		
		return em;

	}
	
	public void cerrarConexion(EntityManager em){
		if (em != null) {
			if (em.isOpen()) {
				em.close();
			}
		}
	}
	
	public List<User> obtenerUsuarios(){
		
		EntityManager em = conexion();

	
		@SuppressWarnings("unchecked")
		List<User> users = em.createNamedQuery("User.findAll").getResultList();
		
		cerrarConexion(em);
		
		return users;
	
	}
	
	public static ConexionBDD getConexion(){
		if(conexion==null){
			conexion = new ConexionBDD();
		}
		
		return conexion;
	}

}
