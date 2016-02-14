package es.uniovi.asw.dbUpdate;

import java.util.List;

import es.uniovi.asw.logica.User;

public interface Read {
	
	/**
	 * Accede a la base de datos y devuelve una lista con los usuarios
	 * @return Lista de usuarios en la BD, o null si la BD esta inactiva
	 */
	public List<User> getUsuariosBD();

}
