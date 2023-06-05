package it.trrileva.exportTracciato;

import java.util.List;

public class Tracciato {
	
	private final char CR = (char) 0x0D;
	private final char LF = (char) 0x0A;
	
	private final String CRLF = "" + CR + LF;
	
	
	String anno;			//obligatorio
	int lung_anno = 4;
	String mese;			//obligatorio
	int lung_mese = 2;
	String ditta;			//obligatorio
	int lung_ditta = 7;
	String dipendete= "?      ";		//obligatorio
	int lung_dipendete = 7;
	String cognome;
	int lung_cognome = 32;
	String nome;
	int lung_nome = 18;
	String cf;				//obligatorio
	int lung_gf = 16;
	
	
	List<Giustificativo> lista;  
	int lung_listGiu = 31;
	
	String prefGiuFine= "RI";
	String codGiuFine = "";
	int lung_codGiuFine = 2;
	String dataGiuFine;
	int lung_dataGiuFine = 8;
	
	String campiVuoti = "";
	int lung_campiVuoti = 38;
	
	String matricola;
	int lung_matricola = 9;
	
	int lung_dataCessazione = 8;
	int lung_voci = 880;
	int lung_spazi = 117;
	
	String fine = CRLF;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tracciato [anno=");
		builder.append(anno);
		builder.append(", mese=");
		builder.append(mese);
		builder.append(", ditta=");
		builder.append(ditta);
		builder.append(", cognome=");
		builder.append(cognome);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cf=");
		builder.append(cf);
		builder.append(", matricola=");
		builder.append(matricola);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
