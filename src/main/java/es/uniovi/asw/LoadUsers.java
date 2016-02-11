package es.uniovi.asw;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

import es.uniovi.asw.dbUpdate.Jpa;
import es.uniovi.asw.logica.User;
import es.uniovi.asw.parser.RCensus;
import es.uniovi.asw.parser.ReadCensus;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {
	
	 ReadCensus readCensus = null;

	public static void main(String... args) {
	
	
		LoadUsers runner = new LoadUsers();
		runner.run(args);

	}

	void run(String... args) {		
//		List<User> users = Jpa.getManager().createNamedQuery("User.findAll",User.class).getResultList();
		Options options = new Options();
		options.addOption("x", false, "add xls file");
		
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = null;
		
		try {
			cmd = parser.parse( options, args);
			
			//Si se indicó la opción x la lectura de datos se hará sobre un 
			//fichero excel
			if(cmd.hasOption("x")) {
				readCensus = new RCensus(args[0]);
			}
			else {
			    System.out.println("Utilizar una de las opciones disponibles: -x");
			}
			
			
			if(readCensus!=null)
				readCensus.readCensus(); 
			
		
					
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	
	}
}
