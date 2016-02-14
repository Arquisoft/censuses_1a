package es.uniovi.asw.dbUpdate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

import es.uniovi.asw.logica.User;
import es.uniovi.asw.reportWriter.WreportP;
import es.uniovi.asw.reportWriter.WriteReport;

public class ReadP implements Read{

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsuariosBD() {
		List<User> usuariosBD = null;
		WriteReport report = new WreportP();

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Jpa.getEmf();
			em = emf.createEntityManager();
			
			usuariosBD = em.createNamedQuery("User.findAll").getResultList();
			
		} catch (PersistenceException e) {
			System.out.println("No se ha podido conectar con la base de datos");
			report.log("No se ha podido conectar con la base de datos");
		} finally {
			if (em != null) {
				if (em.isOpen()) {
					em.close();
				}
			}
		}
		return usuariosBD;
	}

}
