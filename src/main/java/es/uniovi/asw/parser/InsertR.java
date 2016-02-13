package es.uniovi.asw.parser;

import java.util.LinkedList;
import java.util.List;

import es.uniovi.asw.dbUpdate.InsertP;
import es.uniovi.asw.logica.User;
import es.uniovi.asw.util.Comprobador;

public class InsertR implements Insert {
	
	List<User> usuarios = new LinkedList<User>();


	@Override
	public void insertarUsuarios(String nombre, String NIF, String email, 
			String codigoMesa,String contraseña) {
		
		Comprobador.comprobacionDatos(nombre,NIF,email,codigoMesa);	
		usuarios.add(new User(nombre,NIF,email,Integer.parseInt(codigoMesa),
				contraseña));
		
		
	}
	
	public List<User> getUsuarios(){
		return usuarios;
	}

	@Override
	public void enviarUsuarios() {
		
		if(getUsuarios().size()>0){
			es.uniovi.asw.dbUpdate.Insert insert = new InsertP();	
			insert.insertarUsuarios(usuarios);
		}
		
	}
	




}
