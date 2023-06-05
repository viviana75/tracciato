package it.trrileva.exportTracciato;

public enum DipendentiRC10059 {
	
	_000003("000003","RC10059 000003","FELIZIANI","LIVIO","FLZLVI80S19L182X"),
	_000004("000004","RC10059 000004","CIAPPA","GIANLUCA","CPPGLC84L21H501G"),
	_000022("000022","RC10059 000022","SAMMARINI","HARLET","SMMHLT91M71H501J"),
	_000017("000017","RC10059 000017","PASQUALETTI","EMANUELE","PSQMNL84T22H501E"),
	_000018("000018","RC10059 000018","FRANCALANCIA","ELISABETTA","FRNLBT74C50B474I"),
	_000021("000021","RC10059 000021","RAPONI","EMILIANO","RPNMLN93D14I838G"),
	_000015("000015","RC10059 000015","DI CEGLIE","FRANCESCA","DCGFNC87H69H501L"),
	_000020("000020","RC10059 000020","MUCIACCIA","ANTONELLA","MCCNNL88S54H501M");
	
	private final String matricola;
	private final String codice;
	private final String cognome;
	private final String nome;
	private final String cf;
	
	private DipendentiRC10059(String matricola, String codice, String cognome,String nome, String cf) {
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
