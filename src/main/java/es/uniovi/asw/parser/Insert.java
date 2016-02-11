package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.logica.User;

public interface Insert {
	
	
	/**
	 * Recibe los datos de los usuarios y crea objetos User que almacena en una lista
	 * 
	 * @param nombre
	 * @param NIF
	 * @param email
	 * @param codigoMesa
	 * @param contraseña 
	 */
	void insertarUsuarios(String nombre,String NIF,String email,String codigoMesa,
			String contraseña);
	
	
	/**
	 * Devuelve los usuarios que se van a insertar
	 * @return
	 */
	List<User> getUsuarios();


	/**
	 * Envía a un método del componente DBUpdate los usuarios
	 */
	void enviarUsuarios();


}
