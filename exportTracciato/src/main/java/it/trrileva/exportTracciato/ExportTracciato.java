package it.trrileva.exportTracciato;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportTracciato {

	public static void execute(String meseIn, String annoIn, String dittaIn, String filePath) throws Exception {
		// java -cp xmlSplit-1.0.0.jar it.xmlSplit.XmlSplit provaCreazione.xml

		int mese = Integer.parseInt(meseIn);
		int anno = Integer.parseInt(annoIn); 
		String ditta = dittaIn;
		File input = new File(filePath);
		
		try {
			FileInputStream fis = new FileInputStream(input);

			// Trova l'istanza della cartella di lavoro per il file XLSX
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

			// Restituisce il primo foglio dalla cartella di lavoro XLSX
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);

			// Ottieni l'iteratore su tutte le righe nel foglio corrente
			Iterator<Row> rowIterator = mySheet.iterator();

			int riga = 0;
			
			 ArrayList<Riga> righe = new ArrayList<Riga>();
			// ciclo per ogni riga del file XLSX
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				if (riga == 0 || riga == 1 || riga == 2) {riga++; continue;}
				else riga++;

				// Per ogni riga, siscorre ogni colonna
				Iterator<Cell> cellIterator = row.cellIterator();
				
				int colonna = 1;
				
				Riga r = new Riga();
				System.out.print(riga);
				System.out.print("\t");

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case STRING:
						if (colonna == 1) {r.matricola = cell.getStringCellValue();}
						if (colonna == 3) {r.nominativo = cell.getStringCellValue();}
						if (colonna == 4) {r.nome = cell.getStringCellValue();}
						if (colonna == 5) {r.cognome = cell.getStringCellValue();}
						if (colonna == 6) {r.cf = cell.getStringCellValue();}
						if (colonna == 14) {r.task = cell.getStringCellValue();}
						
						if(colonna == 1 || colonna == 14 || colonna == 3 || colonna == 4 || colonna == 5 || colonna == 6)
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					case NUMERIC:
						if (colonna == 1) {r.matricola = ""+(int)cell.getNumericCellValue();}
						if (colonna == 8) {r.giorno = (int)cell.getNumericCellValue();}
						if (colonna == 9) {r.mese = (int)cell.getNumericCellValue();}
						if (colonna == 10) {r.anno = (int)cell.getNumericCellValue();}
						if (colonna == 15) {r.ore = (double)cell.getNumericCellValue();}
						if(colonna == 1 || colonna == 8 || colonna == 9 || colonna == 10 || colonna == 15 )
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					default:

					}
					colonna++;
					
				}
				righe.add(r);
				System.out.println("");

			}

			Collections.sort(righe);

			List<Tracciato> lista = GeneraTracciato.preparaDipendenti(righe, mese, ditta);
			
			GeneraTracciato.cercaDipendenti(lista, ditta);
			
			String nomefile = lista.get(0).ditta+"RLIGHT"+lista.get(0).mese+(lista.get(0).anno.substring(2))+".SEQ";
			String path = input.getPath();
			nomefile = path.substring(0, path.lastIndexOf(File.separator)) + File.separator + nomefile;
			Writer   fstream  = new OutputStreamWriter(new FileOutputStream(nomefile), StandardCharsets.UTF_8);
			BufferedWriter writer = new BufferedWriter(fstream);
			
			GeneraTracciato.generaTracciato(lista, writer);
			
			writer.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}

	}

}
