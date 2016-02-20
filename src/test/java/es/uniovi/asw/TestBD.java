package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import es.uniovi.asw.dbUpdate.Read;
import es.uniovi.asw.dbUpdate.ReadP;
import es.uniovi.asw.logica.User;
import es.uniovi.asw.parser.GeneradorCartasTXT;
import es.uniovi.asw.parser.ParserXLS;
import es.uniovi.asw.parser.RCensus;
import es.uniovi.asw.parser.ReadCensus;

public class TestBD {

	List<User> excel = null;
	List<User> db = null;

	@Before
	public void inicializar() {
		Read read = new ReadP();
		ReadCensus readCensus = new RCensus("Censos.xls",
				new GeneradorCartasTXT(), new ParserXLS());
		readCensus.readCensus();
		excel = readCensus.getUsuarios();
		db = read.getUsuariosBD();
		System.out.println();
	}

	@Test
	public void testNumeroDatos() {
		// Esto significa que la BD esta encendida
		assertEquals(excel.size(), db.size());

	}

	@Test
	public void coincidenciaDatosExcelDB() {
		//comprueba que exista los mismos datos en el excel que en la base de datos
		for (int i = 0; i < excel.size(); i++) {
			assertTrue(db.contains(excel.get(i)));
		}

	}

}
