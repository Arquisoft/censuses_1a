package es.uniovi.asw.util;

public class Comprobador {
	
	public static boolean comprobacionDatos(String nombre,String NIF,String email,
			String codigoMesa){
		
		if(nombre.isEmpty() || NIF.isEmpty() || email.isEmpty() ||
				codigoMesa.isEmpty() ){
			
			return false;
			
		}
		
		
		return true;
	}

}
