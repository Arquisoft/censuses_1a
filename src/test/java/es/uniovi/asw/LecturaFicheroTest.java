package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.logica.User;
import es.uniovi.asw.parser.GeneradorCartasTXT;
import es.uniovi.asw.parser.RCensus;
import es.uniovi.asw.parser.ReadCensus;

public class LecturaFicheroTest {
	
	@Test
	public void evalLectura() {
		/*
		 * Este metodo accede a la BD, asi que no subir descomentado, y que sino da error
		 */
//		ReadCensus readCensus = new RCensus("src/test/resources/Censos.xls",new GeneradorCartasTXT());
//		readCensus.readCensus();
//		List<User> usuarios = readCensus.getUsuarios();
//		
//		//Existen 4 entradas de usuarios en el xls pero solo 2 tiene todos
//		//los campos obligatorios
//		assertEquals(usuarios.size(), 2);
//		
//		User usuario1 = usuarios.get(0);
//		User usuario2 = usuarios.get(1);
//		
//		assertEquals(usuario1.getName(), "Jorge");
//		assertEquals(usuario2.getName(), "Miguel");
//		
//		assertEquals(usuario1.getNIF(), "45443827R");
//		assertEquals(usuario2.getNIF(), "54313432L");
//		
//		assertEquals(usuario1.getEmail(), "jorge@gmail.com");
//		assertEquals(usuario2.getEmail(), "miguel@gmail.com");
//		
//		assertEquals(usuario1.getCodigoMesa(), 1);
//		assertEquals(usuario2.getCodigoMesa(), 2);
				
	}

}
