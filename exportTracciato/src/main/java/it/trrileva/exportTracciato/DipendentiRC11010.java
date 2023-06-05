package it.trrileva.exportTracciato;

public enum DipendentiRC11010 {
	
	_000113("000434","RC11010 000113","STARC","ALESSANDRO","STRLSN80R11H501T"),
	_000099("000099","RC11010 000099","SINDICI","GIORGIA","SNDGRG83R70H501G"),
	_000035("000035","RC11010 000035","PASCUCCI","MANUELA","PSCMNL80M50H501C"),
	_000065("000065","RC11010 000065","ROSATI","GEMMA","RSTGMM83E49D662F"),
	_000106("000106","RC11010 000106","LEONELLI","DAMIANO","LNLDMN85M03E230N"),
	_000054("000054","RC11010 000054","OTTAVIANI","SARA","TTVSRA86A48H501I"),
	_000101("000101","RC11010 000101","CAPRIOLI","MARZIA","CPRMRZ82H58H501Z"),
	_000098("000098","RC11010 000098","FATTORE","MARIO","FTTMRA90D26L725Y"),
	_000072("000072","RC11010 000072","ACRI","DAVIDE","CRADVD82T08H501J"),
	_000074("000074","RC11010 000074","AMORE","MARY","MRAMRY89D66E958D"),
	_000077("000077","RC11010 000077","RAHAMAN","ROBEL","RHMRBL83B15Z249W"),
	_000108("000108","RC11010 000108","PASQUALI","GIULIA","PSQGLI91M56H501V"),
	_000111("000111","RC11010 000111","MORABITO","GABRIELE","MRBGRL01H02H501A");

	
	private final String matricola;
	private final String codice;
	private final String cognome;
	private final String nome;
	private final String cf;
	
	private DipendentiRC11010(String matricola, String codice, String cognome,String nome, String cf) {
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
