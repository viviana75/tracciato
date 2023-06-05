package it.trrileva.exportTracciato;

public enum DipendentiRC11011 {
	
	_000001("000001","RC11011 000001","BENEDETTI ALOISI","AGNESE","BNDGNS79S58H501Q"),
	_000003("000003","RC11011 000003","LOMBARDI","IMMACOLATA","LMBMCL79R66A669L"),
	_000002("000002","RC11011 000002","DE BLASIS","FRANCA","DBLFNC81A69H501D");

	private final String matricola;
	private final String codice;
	private final String cognome;
	private final String nome;
	private final String cf;
	
	private DipendentiRC11011(String matricola, String codice, String cognome,String nome, String cf) {
		this.matricola=matricola;
		this.codice = codice;
		this.cognome = cognome;
		this.nome = nome;
		this.cf = cf;
	}
	public String getCodice() {
		return codice;
	}

	public String getCognome() {
		return cognome;
	}
	public String getNome() {
		return nome;
	}
	public String getCf() {
		return cf;
	}
	public String getMatricola() {
		return matricola;
	}
}
