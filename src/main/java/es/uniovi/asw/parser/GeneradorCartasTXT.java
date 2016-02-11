package es.uniovi.asw.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneradorCartasTXT implements GeneradorCartas{

	

	@Override
	public String generarCarta(String nombre,String email) {
				
		String contraseña = generarContraseña();
		
		File file = new File("cartas/"+email+".txt");
		BufferedWriter bW;
		
		try {
			bW = new BufferedWriter(new FileWriter(file));
			bW.write("Le comunicamos que ha sido añadido al censo electoral "
					+ "y puede entrar en su cuenta con la siguiente"
					+ " información:\n\tUsuario: "+email+"\n\tContraseña: "
					+contraseña);
			
			bW.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return contraseña;
	}

	private String generarContraseña() {
		  char[] caracteres;
		  String password = "";
	        caracteres = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8'
	        		, '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
	        		'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
	        		'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
	        		'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
	        		'u', 'v', 'w', 'x', 'y', 'z'};
	        try {
	            int repet = 10;
	            for (int i = 0; i < repet; i++) {
	            	password += caracteres[new Random().nextInt(62)];
	            }
	            
	        } catch (NumberFormatException ex) {
	            ex.printStackTrace(System.out);
	        }
	        
	       return password; 
	        
	}

}
