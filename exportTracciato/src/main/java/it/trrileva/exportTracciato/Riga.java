package it.trrileva.exportTracciato;

public class Riga implements Comparable<Riga> {

	String matricola;
	String nominativo;
	String nome;
	String cognome;
	String cf;
	Integer giorno;
	Integer mese;
	Integer anno;
	String task;
	Double ore;

	public int compareTo(Riga o) {
		int last = this.nominativo.compareTo(o.nominativo);
	    return last == 0 ? this.giorno.compareTo(o.giorno) : last;
	}



}
