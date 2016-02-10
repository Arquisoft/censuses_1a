package es.uniovi.asw.dbUpdate;

import es.uniovi.asw.logica.User;

public interface Insert {
	
	/**
	 * Recibe un objeto User y lo inserta en la base de datos
	 * 
	 * @param usuario
	 */
	void insertarUsuarios(User usuario);
	

}
