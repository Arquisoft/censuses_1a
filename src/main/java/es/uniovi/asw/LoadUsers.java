package es.uniovi.asw;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import es.uniovi.asw.factorias.CartasFactory;
import es.uniovi.asw.factorias.CartasPDFFactory;
import es.uniovi.asw.factorias.CartasTXTFactory;
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
	 
	 static Map<String,CartasFactory> factorias = new HashMap<String,CartasFactory>();

	public static void main(String... args) {
		
		cargarFactorias();
		LoadUsers runner = new LoadUsers();
		runner.run(args);

	}

	void run(String... args) {		
		Options options = new Options();
		options.addOption("x", false, "add xls file");
		options.addOption("p", false, "generates pdf files");
		options.addOption("t", false, "generates txt files");
		options.addOption("h", false, "help");
		
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = null;
		
		try {
			
			cmd = parser.parse(options, args);

			if(!cmd.hasOption("h")){
			
			//Si se indicó la opción x la lectura de datos se hará sobre un 
			//fichero excel
			if(cmd.hasOption("x") && (cmd.hasOption("p") || cmd.hasOption("t"))) {
				
				for(Option opt:cmd.getOptions())
					if(!opcionFicheroEntrada(opt.getOpt()))
						readCensus = new RCensus(args[0]
								,factorias.get(opt.getOpt()).crearGeneradorCartas());
			}
			else {
			    System.out.println("Opciones no válidas, puedes utilizar"
			    		+ " la opción -h para apreder a utilizar el programa");
			}
			
			
			if(readCensus!=null)
				readCensus.readCensus(); 
			
			
			}else{
				
				System.out.println("------------------------------------------"
						+ "----------------------------");
				
				System.out.println("Ayuda para programa Censuses:");
				System.out.println("Para utilizar el programa debe de "
						+ "especificar el formato de los ficheros de entrada "
						+ "y el formato de las cartas generadas.");
				
				System.out.println();
				
				System.out.println("Los formatos de ficheros de entrada "
						+ "permitidos son:");
				
				System.out.println("  -x -> Archivos excel (Formato xls)");
				
				
				System.out.println("Los formatos de ficheros de salida "
						+ "permitidos son:");
				
				System.out.println("  -t -> Archivo txt");
				System.out.println("  -p -> Archivo pdf");
				
				System.out.println();
				
				System.out.println("Ejemplo: ");
				
				System.out.println("Generar cartas en formato pdf obteniendo "
						+ "los datos de xls:");

				System.out.println("  java -jar target/censuses1a-0.0.1.jar "
						+ "Censos.xls -x -p");
				
				
				System.out.println("------------------------------------------"
						+ "----------------------------");
				
			}
			
		
					
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.exit(0);
	
	}
	
	
	private static void cargarFactorias() {
		factorias.put("t",new CartasTXTFactory());
		factorias.put("p",new CartasPDFFactory());
		
	}
	
	public boolean opcionFicheroEntrada(String option){
		
		if(option.equals("x")){
			return true;
		}
			
		return false;
	}
	
	
}
