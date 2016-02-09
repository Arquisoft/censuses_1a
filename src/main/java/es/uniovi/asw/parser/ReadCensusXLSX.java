package es.uniovi.asw.parser;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadCensusXLSX implements ReadCensus {
	
	
	File fichero;

	public ReadCensusXLSX(String ruta) {
		fichero = new File(ruta);
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
			
			System.out.print(censos.getCell(0,i).getContents()+" - ");
			System.out.print(censos.getCell(1,i).getContents()+" - ");
			System.out.print(censos.getCell(2,i).getContents()+" - ");
			System.out.println(censos.getCell(3,i).getContents());
			
			
		}
			
		
	}

}
