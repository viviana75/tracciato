package it.trrileva.exportTracciato;

public enum Giustificativi {

	ASPE("ASPE", "ASPETTATIVA", "ASPETTATIVA", "AP"), 
	ASS3("ASS3", "ASSENZA", "ASSENZA CON VOCE 0009", "A3"),
	ASSA("ASSA", "ASSENZA CORONAVIRUS", "ASSENZA CORONAVIRUS", "AA"),
	ASS7("ASS7", "ASSENZA INGIUST. GRE", "ASSENZA INGIUSTIFICATA GREEN PASS", "A7"),
	ASS0("ASS0", "ASSENZA INGIUSTIFICA", "ASSENZA INGIUSTIFICATA", "A0"),
	ASS1("ASS1", "ASSENZA NON RETRIBUI", "ASS. NON RETRIBUITA NON SCALA ORE/GG RETRIBUITI", "A1"),
	ASS2("ASS2", "ASSENZA NON RETRIBUI", "ASS. NON RETRIBUITA SCALA ORE/GG RETRIBUITI", "A2"),
	ASS4("ASS4", "ASSENZA NON RETRIBUI", "ASS. NON RETRIBUITA SCALA ORE/GG RETRIBUITI", "A4"),
	ASS5("ASS5", "ASSENZA NON RETRIBUI", "ASS. NON RETRIBUITA SCALA ORE/GG RETRIBUITI", "A5"),
	CIGM("CIGM", "CIG ORDINARIA", "CIG ORDINARIA CON ANTICIPO", "CM"),
	CIGN("CIGN", "CIG ORDINARIA", "CIG ORDINARIA SENZA ANTICIPO", "CN"),
	MA4P("MA4P", "CONG.PAR. COVID-19", "CONGEDO PARENTALE COVID-19 12-16 ANNI D.L. 18/2020", "C7"),
	MA4C("MA4C", "CONG.PAR. COVID-19", "CONGEDO PARENTALE COVID-19 0-12 ANNI D.L. 18/2020", "C9"),
	MA4Q("MA4Q", "CONG.PAR. COVID-19", "CONGEDO PARENTALE COVID-19 0-14 ANNI D.L. 111/2020", "CQ"),
	MA4D("MA4D", "CONG.PAR. COVID-19", "CONGEDO PARENTALE COVID-19 0-12 ANNI D.L. 18/2020", "D0"),
	MA4H("MA4H", "CONG.PAR. COVID-19 H", "CONGEDO PARENTALE COVID-19 HANDICAP", "C0"),
	MA4I("MA4I", "CONG.PAR. COVID-19 H", "CONGEDO PARENTALE COVID-19 HANDICAP", "D1"),
	MA4S("MA4S", "CONGEDO 2021 PER GEN", "CONGEDO 2021 PER GENITORI D.L. 30/2021", "CU"),
	MA4F("MA4F", "CONGEDO ART33/C.1/15", "MA4 ART. 33 COMMA 1 D.LGS 151/2001", "M1"),
	DVV("DVV", "CONGEDO D.LGS 80/201", "CONGEDO D.LGS 80/2015 ART. 24 (utilizzo a giorni)", "DV"),
	DVO("DVO", "CONGEDO D.LGS 80/201", "CONGEDO D.LGS 80/2015 ART. 24 (utilizzo a ore)", "DW"),
	CMT1("CMT1", "CONGEDO MATRIM. DITT", "CONGEDO MATRIMONIALE DITTA", "CD"),
	CMT2("CMT2", "CONGEDO MATRIM. INPS", "CONGEDO MATRIMONIALE INPS", "CI"),
	MA0("MA0", "CONGEDO PARENTALE A", "MA0 ART. 32 D.LGS 151/2001", "M0"),
	CPAF("CPAF", "CONGEDO PATERNITA' F", "CONGEDO PATERNITA' FACOLTATIVA", "C1"),
	CPAO("CPAO", "CONGEDO PATERNITA' O", "CONGEDO PATERNITA' OBBLIGATORIO", "C2"),
	MA4R("MA4R", "CONGEDO STRAORDINARI", "CONGEDO STRAORDINARIO FIGLI DL N. 137/2020", "CR"),
	MA7D("MA7D", "CONGEDO STRAORDINARI", "CONGEDO STRAORDINARIO DISABILI DL N. 137/2020", "D4"),
	MC1("MC1", "CONGEDO STRAORDINARI", "CONGEDO STRAORDINARIO INPS", "MC"),
	MALS("MALS", "CONTINUAZIONE MALATT", "MALATTIA CON CONTINUAZIONE", "MK"),
	DON3("DON3", "DONAZIONE SANGUE", "DONAZIONE SANGUE PER MENSILIZZATI", "D3"),
	FER6("FER6", "FERIE", "FERIE MAGG. 0,20", "F6"), 
	FEGO("FEGO", "FESTIVITA' GODUTA", "FESTIVITA' GODUTA", "FG"),
	FENG("FENG", "FESTIVITA' NON GODUT", "FESTIVITA' NON GODUTA", "FN"),
	FEPG("FEPG", "FESTIVITA' PATRONO G", "FESTIVITA' PATRONO GODUTA", "GP"),
	FEPN("FEPN", "FESTIVITA' PATRONO N", "FESTIVITA' PATRONO NON GODUTA", "NP"),
	NIND("NIND", "GIORNI NON INDENNIZZ", "GG NON INDENNIZZATI IN MALATTIA PER MANCANZA CERT", "NI"),
	INFA("INFA", "INFORTUNIO", "INFORTUNIO AUTOMATICO CON CALCOLI UNIEMENS", "IA"),
	LFES("LFES", "LAVORO FESTIVO", "LAV. FESTIVO", "L1"), 
	LNOT("LNOT", "LAVORO NOTTURNO", "LAVORO NOTTURNO", "L2"),
	LNFE("LNFE", "LAVORO NOTTURNO FEST", "LAV. NOTT. FEST.", "L3"),
	LSFE("LSFE", "LAVORO SUPPLEMENTARE", "LAVORO SUPPLEMENTARE FESTIVO", "LE"),
	LSNO("LSNO", "LAVORO SUPPLEMENTARE", "LAVORO SUPPLEMENTARE NOTTURNO", "LN"),
	LS("LS  ", "LAVORO SUPPLEMENTARE", "LAVORO SUPPLEMENTARE", "LS"),
	MNL2("MNL2", "MAGG. LAV. SUPPLEMEN", "MAGG. LAV. SUPPLEMENT. FESTIVO", "N4"),
	MDF("MDF", "MAGG. LAVORO FESTIVO", "MAGG. LAVORO FESTIVO", "MD"),
	MNF("MNF", "MAGG. LAVORO NOTTURN", "MAGG. LAV. NOTT. FESTIVO", "FM"),
	MN("MN  ", "MAGG. LAVORO NOTTURN", "MAGG. LAVORO NOTTURNO", "LT"), 
	MAL("MAL", "MALATTIA", "MALATTIA", "MA"),
	MATA("MATA", "MATERNITA' ANTICIPAT", "MATERNITA' ANTICIPATA", "MN"),
	MATF("MATF", "MATERNITA' FACOLTATI", "MATERNITA' FACOLTATIVA", "MF"),
	MATO("MATO", "MATERNITA' OBBLIGATO", "MATERNITA' OBBLIGATORIA", "MO"),
	MUDI("MUDI", "MULTA DISCIPLINARE", "MULTA DISCIPLINARE VOCE 0362", "MU"),
	ALLM("ALLM", "ORE ALLATTAMENTO", "ORE ALLATTAMENTO", "AM"),
	OL("OL  ", "ORE LAVORATE ORDINAR", "ORE LAVORATE ORDINARIE", "OL"),
	ORVM("ORVM", "ORE VIAGGIO", "ORE VIAGGIO VOCE 0125", "OM"),
	MA6("MA6", "PERM. ART33/ 6/ 104-", "MA6 ART. 33 COMMA 6 D.LEGGE 104", "MH"),
	MB5("MB5", "PERM. ART33/ 6/ 104-", "MB5 ART. 33 COMMA 6 LEGGE 104/1992", "ML"),
	MA6A("MA6A", "PERM. ART33/ 6/ 104-", "MA6 ART. 33 COMMA 6 D.LEGGE 104", "MZ"),
	MB3("MB3", "PERM. ART42/ 1/ 151-", "MB3 ART. 42 COMMA 1 DLGS 151/2001", "MQ"),
	MA5("MA5", "PERM. ART42/2-3/151-", "MA5 ART. 42 COMMI 2 E 3 D.LGS 151/2001", "M5"),
	MB4("MB4", "PERM. ART47/ 2/ 151-", "MB4 ART. 47 COMMA 2 DLGS 151/2001", "MY"),
	MA3("MA3", "PERM. ART49/ 1/ 151-", "MA3 ART. 49 COMMA 1 D.LGS 151/2001", "MB"),
	MA7C("MA7C", "PERM. COVID-19 L.104", "MV5 COVID-19 ART. 33 COMMA 3 E 6 LEGGE 104/1992", "C5"),
	MB5C("MB5C", "PERM. COVID-19 L.104", "MV4 COVID-19 ART. 33 COMMA 3 E 6 LEGGE 104/1992", "C6"),
	BRA1("BRA1", "PERM. EX ART33/3/104", "MA7 EX ART. 33 COMMA 3 LEGGE 104/1992", "M7"),
	MB0("MB0", "PERM.ART35/2/151-01", "MB0 ART. 35 COMMA2 DLGS 151/2001 A ORE", "MG"),
	MB2("MB2", "PERM.ART35/2/151-01", "MB2 ART. 35 COMMA2 DLGS 151/2001", "MI"),
	PMEL("PMEL", "PERMESSO ELEZIONI", "PERMESSO ELEZIONI", "PZ"),
	PMES("PMES", "PERMESSO ESAMI", "PERMESSO ESAMI", "PE"),
	PMMF("PMMF", "PERMESSO MOTIVI FAMI", "PERMESSO MOTIVI FAMILIARI L.53/2000", "CP"),
	//PMNR("PMNR", "PERMESSO NON RETRIBU", "PERMESSO NON RETRIBUITO", "PN"),
	PMNR("PMNR", "PERMESSO NON RETRIBU", "PERMESSO NON RETRIBUITO", "XN"),
	PMLU("PMLU", "PERMESSO PER LUTTO", "PERMESSO PER LUTTO", "LP"),
	PMSI("PMSI", "PERMESSO SINDACALE", "PERMESSO SINDACALE", "PI"),
	PMST("PMST", "PERMESSO STUDIO", "PERMESSO DI STUDIO", "PS"), 
	ROL("ROL", "R.O.L.", "RIDUZIONE ORARIO LAVORO", "RL"),
	INFR("INFR", "RICADUTA INFORTUNIO", "RICADUTA INFORTUNIO", "IR"),
	MALR("MALR", "RICADUTA MALATTIA", "MALATTIA CON RICADUTA", "MR"),
	RIOD("RIOD", "RICOVERO OSPED. DIMI", "RICOVERO OSPEDALIERO DIMISSIONI", "R2"),
	RIOS("RIOS", "RICOVERO OSPEDALIERO", "RICOVERO OSPEDALIERO", "RO"),
	RCOM("RCOM", "RIPOSO COMPENSATIVO", "RIPOSO COMPENSATIVO ELEZIONI", "CZ"),
	RCNG("RCNG", "RIPOSO NON GODUTO PE", "RIPOSO NON GODUTO PER ELEZIONI", "NZ"),
	SMWO("SMWO", "SMART WORKING", "SMART WORKING", "SW"),
	SOSD("SOSD", "SOSPENSIONE DISCIPLI", "SOSPENSIONE DISCIPLINARE VOCE 0633", "DI"),
	SOSP("SOSP", "SOSPENSIONE LAVORO", "SOSPENSIONE LAVORO", "SX"),
	SNDF("SNDF", "STRAORD. NOTT. FESTI", "STR. NOTT.DOM. FEST.", "NA"),
	SNSF("SNSF", "STRAORD. NOTT. FESTI", "STR NOTT. SAB FEST.", "NE"),
	SNF("SNF", "STRAORD. NOTT. FESTI", "STR. NOTT. FEST.", "NF"),
	SNS("SNS", "STRAORD. NOTTURNO", "STR. NOTT. SAB.", "NB"), 
	SD("SD  ", "STRAORDINARIO", "STR. DIURNO", "SD"),
	SDS("SDS", "STRAORDINARIO", "STR. DIURNO DI SAB.", "SS"),
	SDD("SDD", "STRAORDINARIO FESTIV", "STR. DIURNO DOM.", "DD"),
	SDDF("SDDF", "STRAORDINARIO FESTIV", "STR. DIU DOM.FEST.", "DF"),
	SDSF("SDSF", "STRAORDINARIO FESTIV", "STR. DIU SAB FEST.", "FS"),
	SDF("SDF", "STRAORDINARIO FESTIV", "STR. DIURNO FEST.", "SF"),
	SN("SN  ", "STRAORDINARIO NOTTUR", "STR. NOTT. NO TURNO", "SN");

	private final String cod;
	private final String desc;
	private final String descCompleta;
	private final String descBreve;

	private Giustificativi(String cod, String desc, String descCompleta, String descBreve) {
		this.cod = cod;
		this.desc = desc;
		this.descCompleta = descCompleta;
		this.descBreve = descBreve;
	}

	public String getDesc() {
		return desc;
	}

	public String getDescCompleta() {
		return descCompleta;
	}

	public String getDescBreve() {
		return descBreve;
	}

	public String getCod() {
		return cod;
	}

}
