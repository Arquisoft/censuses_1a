package es.uniovi.asw.util;


import es.uniovi.asw.reportWriter.WreportP;
import es.uniovi.asw.reportWriter.WriteReport;

public class Comprobador {
	
	static WriteReport report = new WreportP();
	
	public static boolean comprobacionDatos(String nombre,String NIF,String email,
			String codigoMesa){
		
		if(nombre.isEmpty() || NIF.isEmpty() || email.isEmpty() ||
				codigoMesa.isEmpty()){
			
			if(nombre.isEmpty()){
				report.log("Encontrado campo nombre vacio");	
			}
			
			if(NIF.isEmpty()){
				report.log("Encontrado campo NIF vacio");	
			}
			
			if(email.isEmpty()){
				report.log("Encontrado campo email vacio");	
			}
			
			if(codigoMesa.isEmpty()){
				report.log("Encontrado campo código mesa vacio");	
			}
			
			return false;
			
		}
		
		//Comprobación codigoMesa es númerico
		try{
			
			Integer.parseInt(codigoMesa);
		
		}catch(NumberFormatException e){
			
			report.log("El codigo de mesa debe ser numérico");
			
		}
		
		
		return true;
	}

}
