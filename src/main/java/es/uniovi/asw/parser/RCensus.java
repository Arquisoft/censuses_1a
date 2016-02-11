package es.uniovi.asw.parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import es.uniovi.asw.dbUpdate.Jpa;
import es.uniovi.asw.logica.User;
import es.uniovi.asw.util.Comprobador;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class RCensus implements ReadCensus {
		
	File fichero;
	Insert insert;
	GeneradorCartas generador;
	
	

	public RCensus(String ruta) {
		fichero = new File(ruta);
		insert = new InsertR();
		generador = new GeneradorCartasTXT();
	}

	@Override
	public void readCensus() {
		List<User> users = Jpa.createEntityManager().createNamedQuery("User.findAll",User.class).getResultList();
		System.out.println("Se han leido" + users.size());
		for (User user : users) {
			System.out.println(user.toString());
		}
		Workbook wB = null;
		
		long t1 = System.currentTimeMillis();
		
		try {
			wB = Workbook.getWorkbook(fichero);
			
		} catch (BiffException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Sheet censos = wB.getSheet("Censos");
	
		
			
		for(int i=1;i<censos.getRows();i++){
			
			String nombre = censos.getCell(0,i).getContents();
			String NIF = censos.getCell(1,i).getContents();
			String email = censos.getCell(2,i).getContents();
			String codigoMesa = censos.getCell(3,i).getContents();

			
			if(Comprobador.comprobacionDatos(nombre,NIF,email,codigoMesa)){
			
				String contraseña = generador.generarCarta(nombre, email);
				insert.insertarUsuarios(nombre, NIF, email, codigoMesa,contraseña);
				
			
			}
			
					
		}
		
		insert.enviarUsuarios();
			
		long t2 = System.currentTimeMillis();
		
		System.out.println(t2-t1);
		
			
	}
	
	public List<User> getUsuarios(){
		return insert.getUsuarios();
	}
	
}
