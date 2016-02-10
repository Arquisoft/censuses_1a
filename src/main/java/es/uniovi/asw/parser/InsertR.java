package es.uniovi.asw.parser;

import java.util.LinkedList;
import java.util.List;

import es.uniovi.asw.logica.User;
import es.uniovi.asw.util.Comprobador;

public class InsertR implements Insert {
	
	List<User> usuarios = new LinkedList<User>();

	@Override
	public void insertarUsuarios(String nombre, String NIF, String email, 
			String codigoMesa) {
		
		Comprobador.comprobacionDatos(nombre,NIF,email,codigoMesa);	
		usuarios.add(new User(nombre,NIF,email,Integer.parseInt(codigoMesa)));
		
		//Pasar a dbUpdate 
		
	}
	
	public List<User> getUsuarios(){
		return usuarios;
	}
	




}
