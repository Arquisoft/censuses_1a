package es.uniovi.asw;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.logica.User;
import es.uniovi.asw.parser.GeneradorCartasTXT;
import es.uniovi.asw.parser.ParserXLS;
import es.uniovi.asw.parser.RCensus;
import es.uniovi.asw.parser.ReadCensus;


public class InsertarUsuariosTest {
	
	List<User>usuarios=null;
	
	//@Before
	public void insertarUsuarios() throws IOException
	{
				
		ReadCensus r=new RCensus("src/test/resources/Censos.xls",new GeneradorCartasTXT(),new ParserXLS());
		r.readCensus();
		
		//Obtiene los usuarios antes de ser insertados en BDD
		usuarios=r.getUsuarios();
		
		
	}
	

	//@Test
	public void testUsuarios() throws IOException {
		
		
	}
	
	//@Test
	public void testContraseña() throws IOException {
	
	
		
	}

}
