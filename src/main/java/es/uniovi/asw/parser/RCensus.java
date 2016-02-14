package es.uniovi.asw.parser;

import java.io.File;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.logica.User;
import es.uniovi.asw.util.Comprobador;

public class RCensus implements ReadCensus {
		
	File fichero;
	Insert insert;
	
	Parser parser;
	GeneradorCartas generador;

	public RCensus(String ruta, GeneradorCartas generadorCartas,Parser parser) {
		fichero = new File(ruta);
		insert = new InsertR();
		generador = generadorCartas;
		this.parser = parser;
	}

	@Override
	public void readCensus() {

		List<Map<String,String>> usuarios = parser.leerDatos(fichero);
		
		if(usuarios!=null){

			String nombre = "";
			String NIF = "";
			String email = "";
			String codigoMesa ="";
			
			for(Map<String,String> user:usuarios){
			
				
				nombre = user.get("nombre");
				NIF = user.get("NIF");
				email = user.get("email");
				codigoMesa = user.get("codigoMesa");
				
				if(Comprobador.comprobacionDatos(nombre,NIF,email,codigoMesa)){
					String contraseña = generador.generarCarta(nombre, email);
					insert.insertarUsuarios(nombre, NIF, email, codigoMesa,contraseña);
					
				
				}
				
			}
					
			
			//insert.enviarUsuarios();
			
		}
					
			
	}
	
	public List<User> getUsuarios(){
		return insert.getUsuarios();
	}
	
}
