package es.uniovi.asw.dbUpdate;

import java.util.List;

import es.uniovi.asw.logica.User;

public interface Insert {
	
	/**
	 * Inserta los usuarios en una colección y comprueba que sean válidos
	 * 
	 * @param nombre
	 * @param NIF
	 * @param email
	 * @param codigoMesa
	 */
	void insertarUsuarios(String nombre,String NIF,String email,String codigoMesa);
	
	
	/**
	 * Devuelve los usuarios que se van a insertar
	 * @return
	 */
	List<User> getUsuarios();

}
