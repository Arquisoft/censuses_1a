package es.uniovi.asw.parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import es.uniovi.asw.dbUpdate.Insert;
import es.uniovi.asw.logica.User;
import es.uniovi.asw.util.Comprobador;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class RCensus implements ReadCensus {
		
	File fichero;
	Insert insert;

	public RCensus(String ruta) {
		fichero = new File(ruta);
		insert = new InsertR();
	}

	@Override
	public void readCensus() {
		
		Workbook wB = null;
		
		try {
			wB = Workbook.getWorkbook(fichero);
			
		} catch (BiffException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Sheet censos = wB.getSheet("Censos");
		
		System.out.println("Leyendo usuarios...");
			
		for(int i=1;i<censos.getRows();i++){
			
			String nombre = censos.getCell(0,i).getContents();
			String NIF = censos.getCell(1,i).getContents();
			String email = censos.getCell(2,i).getContents();
			String codigoMesa = censos.getCell(3,i).getContents();
				
			System.out.print(nombre+" - ");
			System.out.print(NIF+" - ");
			System.out.print(email+" - ");
			System.out.println(codigoMesa);
			
			if(Comprobador.comprobacionDatos(nombre,NIF,email,codigoMesa)){
			
				insert.insertarUsuarios(nombre, NIF, email, codigoMesa);
			
			}
					
		}
			
	}
	
	public List<User> getUsuarios(){
		return insert.getUsuarios();
	}
	
}
