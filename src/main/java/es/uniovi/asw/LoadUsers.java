package es.uniovi.asw;

import es.uniovi.asw.parser.RCensus;
import es.uniovi.asw.parser.ReadCensus;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		LoadUsers runner = new LoadUsers();
		runner.run(args);

	}

	void run(String... args) {		
		ReadCensus readCensus = new RCensus(args[0]);
		readCensus.readCensus();
	
	}
}
