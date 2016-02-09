package es.uniovi.asw.util;

public class Comprobador {
	
	public static boolean comprobacionDatos(String nombre,String NIF,String email,
			String codigoMesa){
		
		if(nombre.isEmpty() || NIF.isEmpty() || email.isEmpty() ||
				codigoMesa.isEmpty()){
			
				//Añadir a fichero Log problema
			
			return false;
			
		}
		
		//Comprobación codigoMesa es númerico
		try{
			
			Integer.parseInt(codigoMesa);
		
		}catch(NumberFormatException e){
			
			//Añadir a fichero Log problema
			
		}
		
		
		return true;
	}

}
