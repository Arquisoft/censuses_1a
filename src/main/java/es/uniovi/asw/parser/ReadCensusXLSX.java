package es.uniovi.asw.parser;

import java.io.File;
import java.io.IOException;

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
		
		
		System.out.println(wB.getSheet("Censos").getCell(0, 0).getContents());
		
		
		
	}

}
