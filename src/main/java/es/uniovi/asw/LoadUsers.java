package es.uniovi.asw;

import es.uniovi.asw.parser.ReadCensus;
import es.uniovi.asw.parser.ReadCensusXLSX;

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

	// TODO
	void run(String... args) {
		System.out.println("TODO");
		
		ReadCensus readCensus = new ReadCensusXLSX(args[0]);
		readCensus.readCensus();
	
	}
}
