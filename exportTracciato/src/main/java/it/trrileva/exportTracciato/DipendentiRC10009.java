package it.trrileva.exportTracciato;

public enum DipendentiRC10009 {
	
	_000001("000001","RC10009 000001","BALDARI","NICOLA","BLDNCL77A18H501I"),
	_000037("000037","RC10009 000037","ROTONDO","ELISA","RTNLSE97B58H501Q"),
	_000042("000042","RC10009 000042","MARTINI","LAURA","MRTLRA92A49H501H"),
	_000010("000010","RC10009 000010","IULIO","CARLO","LIUCRL92B20F839T"),
	_000002("000002","RC10009 000002","ATTIANESE","ANDREA","TTNNDR85R17H501E"),
	_000006("000006","RC10009 000006","PANEI","ERIKA","PNARKE87T51H501B"),
	_000022("000022","RC10009 000022","GABRIELLI","VALERIO","GBRVLR91H22D810G"),
	_000033("000033","RC10009 000033","CIRIGLIANO","ROBERTO","CRGRRT95B24H501I"),
	_000035("000035","RC10009 000035","LOGOSHA","OLEKSANDR","LGSLSN84B11Z138Z"),
	_000036("000036","RC10009 000036","MARTINI","FRANCESCA","MRTFNC74A55H501G"),
	_000029("000029","RC10009 000029","LANDONI","MIRIAM","LNDMRM89S62D708Q"),
	_000034("000034","RC10009 000034","VIOLO","ALESSANDRA","VLILSN94P66H501P"),
	_000041("000041","RC10009 000041","CACCHIONE","LORENZO","CCCLNZ92T08H501O"),
	_000040("000040","RC10009 000040","TRIPODI","MARINA","TRPMRN93R59G317A");

	
	private final String matricola;
	private final String codice;
	private final String cognome;
	private final String nome;
	private final String cf;
	private DipendentiRC10009(String matricola, String codice, String cognome,String nome, String cf) {
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
