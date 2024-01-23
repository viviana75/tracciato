package it.trrileva.exportTracciato;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.trrileva.exportTracciato.Easter.YearOutOfRangeException;

public class GeneraTracciato {

	
	public static void generaTracciato(List<Tracciato> lista, BufferedWriter writer) throws IOException{
		for (Tracciato tracciato : lista) {
			String rigaTracciato = "";

			rigaTracciato += tracciato.anno;
			rigaTracciato += tracciato.mese;
			rigaTracciato += tracciato.ditta;
			rigaTracciato += tracciato.dipendete;
			rigaTracciato += tracciato.cognome;
			rigaTracciato += tracciato.nome;
			rigaTracciato += tracciato.cf;

			for (Giustificativo giustificativo : tracciato.lista) {

				for (Tredicesiomo tredicesiomo : giustificativo.listGiu) {
					rigaTracciato += tredicesiomo.pref;
					rigaTracciato += Utils.aggiungiSpazi(tredicesiomo.cod, tredicesiomo.lung_cod);
					rigaTracciato += Utils.aggiungiSpazi(tredicesiomo.ore, tredicesiomo.lung_ore);
					rigaTracciato += Utils.aggiungiSpazi(tredicesiomo.valore, tredicesiomo.lung_valore);
					rigaTracciato += Utils.aggiungiSpazi(tredicesiomo.perc, tredicesiomo.lung_perc);
					rigaTracciato += Utils.aggiungiSpazi(tredicesiomo.spazio, tredicesiomo.lung_spazio);
				}
				if (giustificativo.listGiu.size() < giustificativo.lung_listGiu) {
					int lunghezza = giustificativo.lung_listGiu - giustificativo.listGiu.size();
					for (int i = 0; i < lunghezza; i++) {
						Tredicesiomo t = new Tredicesiomo();
						rigaTracciato += Utils.aggiungiSpazi(t.pref, t.lug_tot);
					}
				}

				rigaTracciato += giustificativo.oreTeoriche;
				rigaTracciato += giustificativo.tipoGiorno;
				rigaTracciato += Utils.aggiungiSpazi(giustificativo.codCantiere, giustificativo.lung_codCantiere);
				rigaTracciato += Utils.aggiungiSpazi(giustificativo.spazio1, giustificativo.lung_spazio1);

			}

			rigaTracciato += tracciato.prefGiuFine;
			rigaTracciato += Utils.aggiungiSpazi(tracciato.codGiuFine, tracciato.lung_codGiuFine);
			rigaTracciato += tracciato.dataGiuFine;

			rigaTracciato += Utils.aggiungiSpazi(tracciato.campiVuoti, tracciato.lung_campiVuoti);
			rigaTracciato += Utils.aggiungiSpazi(tracciato.matricola, tracciato.lung_matricola);
			rigaTracciato += Utils.aggiungiSpazi("", tracciato.lung_dataCessazione);
			rigaTracciato += Utils.aggiungiSpazi("", tracciato.lung_voci);
			rigaTracciato += Utils.aggiungiSpazi("", tracciato.lung_spazi);

			rigaTracciato += tracciato.fine;

			//System.out.print(rigaTracciato);
			
		    writer.append(rigaTracciato);		    

		}

	}
	
	public static void cercaDipendenti(List<Tracciato> lista, String ditta) throws ParseException, YearOutOfRangeException {
		int size = 0;
		switch (ditta) {
		case "RC10001":
			size = DipendentiRC10001.values().length;
			if (lista.size() < size) {
				
				for (DipendentiRC10001 d : DipendentiRC10001.values()) { 
				    boolean trovato = false;
				    for (Tracciato tracciato : lista) {
				    	if( d.getCf().equals(tracciato.cf)) {
				    		trovato = true;
				    		break;
				    	}
				    		
					}
				    if (!trovato) {
				    	//aggiungi dip alla lsita
				    	Map<Integer, List<Giorno>> giorni = new HashMap<Integer, List<Giorno>>();
				    	Tracciato t = Dipendente.prepara(d.getCognome(), d.getNome(), d.getCf(), d.getMatricola(), giorni, lista.get(0).anno, lista.get(0).mese, lista.get(0).ditta);
				    	System.out.println(t.toString());
				    	lista.add(t);
				    }
				}
			}
			break;
		case "RC10009":
			size = DipendentiRC10009.values().length;
			break;
		case "RC10059":
			size = DipendentiRC10059.values().length;
			break;
		case "RC11010":
			size = DipendentiRC11010.values().length;
			break;
		case "RC11011":
			size = DipendentiRC11011.values().length;
			break;

		default:
			break;
		}
		
		System.out.println(size);
		System.out.println(lista.size());
		
		
		
		
	}
	

	public static List<Tracciato> preparaDipendenti2 (ArrayList<Riga> righe, int mese, String ditta) throws ParseException, YearOutOfRangeException {
		List<Tracciato> lista = new ArrayList<Tracciato>();
		Map<Integer, List<Giorno>> giorni = new HashMap<Integer, List<Giorno>>();
		List<Giorno> listaGirono= new ArrayList<Giorno>();
		Tracciato t = null;
		String nominativo = righe.get(0).nominativo;
		for (Riga riga : righe) {
			
			String data = riga.giorno + "/" + riga.mese + "/" + riga.anno;
			if (nominativo.equalsIgnoreCase(riga.nominativo)) {
				if (riga.task == null || riga.task.toLowerCase().contains("Inizio-Fine Contratto".toLowerCase()) ||
						riga.task.toLowerCase().contains("Recupero".toLowerCase()) ||
						riga.ore == 0d || riga.mese != mese || trovaGiustificativo(riga.task, data)== null) {
					t = Dipendente.prepara(riga.cognome, riga.nome, riga.cf, riga.matricola, giorni, riga.anno+"", riga.mese+"", ditta);
					continue;
				}
				
				t = tornaGiornoTracciato2(riga, mese, ditta, giorni, data, listaGirono);
				
			} else {
				lista.add(t);
				nominativo = riga.nominativo;
				//System.out.println(nominativo);
				giorni = new HashMap<Integer, List<Giorno>>();
				listaGirono= new ArrayList<Giorno>();
				if (riga.task == null || riga.task.toLowerCase().contains("Inizio-Fine Contratto".toLowerCase()) ||
						riga.task.toLowerCase().contains("Recupero".toLowerCase()) ||
						riga.ore == 0d || riga.mese != mese || trovaGiustificativo(riga.task, data)== null) {
					t = Dipendente.prepara(riga.cognome, riga.nome, riga.cf, riga.matricola, giorni, riga.anno+"", riga.mese+"", ditta);
					continue;
				}
				t = tornaGiornoTracciato2(riga, mese, ditta, giorni, data, listaGirono);
			}
			
		}
		lista.add(t);
		
		return lista;
		
	}
	
	public static List<Tracciato> preparaDipendenti (ArrayList<Riga> righe, int mese, String ditta) throws ParseException, YearOutOfRangeException {
		
		List<Tracciato> lista = new ArrayList<Tracciato>();
		
		//Map<Integer, Giorno> giorni = new HashMap<Integer, Giorno>();
		
		Map<Integer, List<Giorno>> giorni = new HashMap<Integer, List<Giorno>>();
		List<Giorno> listaGirono= new ArrayList<Giorno>();
		Tracciato t = null;
		String nominativo = righe.get(0).nominativo;
		//System.out.println(nominativo);
		
		for (Riga riga : righe) {
			
			String data = riga.giorno + "/" + riga.mese + "/" + riga.anno;
			//System.out.println(data);
			
			if (nominativo.equalsIgnoreCase(riga.nominativo)) {
				if (riga.task.toLowerCase().contains("Inizio-Fine Contratto".toLowerCase()) ||
						riga.task.toLowerCase().contains("Recupero".toLowerCase()) ||
						riga.ore == 0d || riga.mese != mese || trovaGiustificativo(riga.task, data)== null) {
					t = Dipendente.prepara(riga.cognome, riga.nome, riga.cf, riga.matricola, giorni, riga.anno+"", riga.mese+"", ditta);
					continue;
				}
				t = tornaGiornoTracciato(riga, mese, ditta, giorni, data, listaGirono);

			} else {
				lista.add(t);
				nominativo = riga.nominativo;
				//System.out.println(nominativo);
				giorni = new HashMap<Integer, List<Giorno>>();
				listaGirono= new ArrayList<Giorno>();
				if (riga.task.toLowerCase().contains("Inizio-Fine Contratto".toLowerCase()) ||
						riga.task.toLowerCase().contains("Recupero".toLowerCase()) ||
						riga.ore == 0d || riga.mese != mese || trovaGiustificativo(riga.task, data)== null) {
					t = Dipendente.prepara(riga.cognome, riga.nome, riga.cf, riga.matricola, giorni, riga.anno+"", riga.mese+"", ditta);
					continue;
				}
				t = tornaGiornoTracciato(riga, mese, ditta, giorni, data, listaGirono);

			}
			
		}
		lista.add(t);
		
		return lista;
		
	}
	
	private static Tracciato tornaGiornoTracciato2(Riga riga, int mese, String ditta, Map<Integer, List<Giorno>> giorni, String data, List<Giorno> listaGirono) throws ParseException, YearOutOfRangeException {
		Tracciato t = null;
		listaGirono = giorni.get(riga.giorno);
		if (listaGirono == null)
			listaGirono= new ArrayList<Giorno>();
		Giorno giorno = new Giorno();
		giorno.giust 	= trovaGiustificativo(riga.task, data);
		int ore = ((int)(riga.ore * 100));
		if (ore < 100) 
			giorno.ore 		= "000" + ore;
		else if (ore >= 1000 )
			giorno.ore 		= "0" + ore;
		else
			giorno.ore 		= "00" + ore;
		
		giorno.oredif 	= "00000";
		
		listaGirono.add(giorno);
		giorni.put(riga.giorno, listaGirono);
		t = Dipendente.prepara(riga.cognome, riga.nome, riga.cf, riga.matricola, giorni, riga.anno+"", riga.mese+"", ditta);
		
		return t;
	}
		
	
	private static Tracciato tornaGiornoTracciato(Riga riga, int mese, String ditta, Map<Integer, List<Giorno>> giorni, String data, List<Giorno> listaGirono) throws ParseException, YearOutOfRangeException {
		Tracciato t = null;

		//System.out.println(nominativo);
		listaGirono = giorni.get(riga.giorno);
		if (listaGirono == null)
			listaGirono= new ArrayList<Giorno>();
		
		Giorno giorno = new Giorno();
		giorno.giust 	= trovaGiustificativo(riga.task, data);

		
		
		int ore = ((int)(riga.ore * 100));
		if (ore < 100) 
			giorno.ore 		= "000" + ore;
		else if (ore >= 1000 )
			giorno.ore 		= "0" + ore;
		else
			giorno.ore 		= "00" + ore;
		
		int oretotali = Integer.parseInt( Utils.getOreDip(riga.cf, ditta) );
		
		for (Giorno _giorno : listaGirono) {
			oretotali -= Integer.parseInt( _giorno.oredif);
		}
		
		giorno.oredif 	= "00" + ((int)(oretotali - (riga.ore * 100)));
		listaGirono.add(giorno);
		giorni.put(riga.giorno, listaGirono);
		
		if (giorno.giust == Giustificativi.SDS) {
			System.out.println(riga.nominativo);
			System.out.println(giorno.ore);
			System.out.println(giorno.oredif);
		}
		
		t = Dipendente.prepara(riga.cognome, riga.nome, riga.cf, riga.matricola, giorni, riga.anno+"", riga.mese+"", ditta);
		
		return t;
	}
	
	private static Giustificativi trovaGiustificativo(String task, String data) throws ParseException {
		
		if (task.trim().toLowerCase().contains("Assenza Ingiustificata".toLowerCase()))
			return Giustificativi.PMNR; //ASS0
		if (task.trim().toLowerCase().contains("Assenza Non Retribuita".toLowerCase()))
			return Giustificativi.PMNR; //ASS1
		if (task.trim().toLowerCase().contains("Permesso Non Retribuito".toLowerCase()))
			return Giustificativi.PMNR; 
		if (task.trim().toLowerCase().contains("Congedo Matrimoniale".toLowerCase()))
			return Giustificativi.CMT1;
		if (task.trim().toLowerCase().contains("Infortuni".toLowerCase()))
			return Giustificativi.INFA;
		if (task.trim().toLowerCase().contains("Malattia".toLowerCase()))
			return Giustificativi.MAL;
		if (task.trim().toLowerCase().contains("Permessi Handicap l. 104/92".toLowerCase()))
			return Giustificativi.BRA1;
		if (task.trim().toLowerCase().contains("Ferie".toLowerCase()))
			return Giustificativi.FER6;
		if (task.trim().toLowerCase().contains("Permesso".toLowerCase()))
			return Giustificativi.ROL;
		if (task.trim().toLowerCase().contains("Festività Patrono".toLowerCase()))
			return Giustificativi.FEGO;
		if (task.trim().toLowerCase().contains("Sanzione Disciplinare".toLowerCase()))
			return Giustificativi.SOSD;
		if (task.trim().toLowerCase().contains("STRAORDINARIO ORE VIAGGIO".toLowerCase()))
			return Giustificativi.ORVM;
		if (task.trim().toLowerCase().contains("STRAORDINARIO FERIALE".toLowerCase())) {
			if (Utils.isSabato(data)) 
				return Giustificativi.SDS;
			else 
				return Giustificativi.SD;
		}
		if (task.trim().toLowerCase().contains("STRAORDINARIO FESTIVO LAVORATO".toLowerCase())
				|| task.trim().toLowerCase().contains("STRAORDINARIO FESTIVO DIURNO".toLowerCase()) )
			return Giustificativi.SDF;
		
		if (task.trim().toLowerCase().contains("PRESENZA".toLowerCase()))
			return Giustificativi.OL;
		
		return null;
	}
	
	



}
