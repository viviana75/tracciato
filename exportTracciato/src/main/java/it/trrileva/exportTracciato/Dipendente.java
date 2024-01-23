package it.trrileva.exportTracciato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import it.trrileva.exportTracciato.Easter.YearOutOfRangeException;

public class Dipendente {
	

	public static Tracciato prepara(String cognome, String nome, String cf, String matricola,
			Map<Integer, List<Giorno>> giorni, String anno, String mese, String ditta) throws ParseException, YearOutOfRangeException {
		Tracciato dipendente = new Tracciato();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		dipendente.anno = anno;
		dipendente.mese = Utils.aggiungiZeri(mese, dipendente.lung_mese);
		dipendente.ditta = ditta;
		dipendente.dipendete = "?      ";
		dipendente.cognome = Utils.aggiungiSpazi( Utils.togliLettereAccentate(cognome), dipendente.lung_cognome);
		dipendente.nome = Utils.aggiungiSpazi( Utils.togliLettereAccentate(nome), dipendente.lung_nome);
		dipendente.cf = cf; 

		//System.out.println(cognome+ " " + nome+ " " + matricola);
		dipendente.matricola = Utils.aggiungiZeri(matricola, dipendente.lung_matricola);

		List<Giustificativo> listaGIU = new ArrayList<Giustificativo>();
		
		int giorniMese = Utils.giorniMese(Integer.parseInt(dipendente.anno), Integer.parseInt(dipendente.mese));

		for (int i = 1; i < (giorniMese+1); i++) {
			Giustificativo giu = new Giustificativo();
			List<Tredicesiomo> lista = new ArrayList<Tredicesiomo>();

			//Giorno giorno = giorni.get(i);
			
			List<Giorno> listaGiorno = giorni.get(i);
			
			int straordinari = 0;
			int oreLavorate = 0;
			int oreLavorateS = 0;
			int oredip = 0;
			int oredifferenza = 0;
			
			int numGiorni = listaGiorno != null ? listaGiorno.size() : 0;
			int indice = 0;
			
			for (int j = 0; j < 13; j++) {
				
				Giorno giorno = listaGiorno != null ? indice < listaGiorno.size() ? listaGiorno.get(indice): null : null;

				Tredicesiomo t = new Tredicesiomo();
				if (j < numGiorni || j == 0) {
					if (giorno != null) {
						
						String oreTotDip = "00" + Utils.getOreDip(cf,ditta);
						if (oreTotDip.equals("00000"))
							oredip = Integer.parseInt(giorno.ore);
						else 
							oredip = Integer.parseInt(Utils.getOreDip(cf,ditta));

						switch (giorno.giust) {
						
						case OL:
							t.cod = Giustificativi.OL.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							if (oreTotDip.equals("00000"))
								oredip = Integer.parseInt(giorno.ore);
							
							break;
							
						case ROL:

							t.cod = Giustificativi.ROL.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							if (!oreTotDip.equals("00000") && !giorno.ore.equals(oreTotDip)) {
								try {oreLavorate = Integer.parseInt(giorno.oredif);}catch (Exception e) {}
							}
							break;
						
						case FER6:
							t.cod = Giustificativi.FER6.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							
							break;
							
						case MAL:
							t.cod = Giustificativi.MAL.getDescBreve();
							//t.ore = giorno.ore;
							t.ore = "00000";
							indice++;
							
							break;
							
						case BRA1:

							t.cod = Giustificativi.BRA1.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							if (!oreTotDip.equals("00000") && !giorno.ore.equals(oreTotDip)) {
								try {oreLavorate = Integer.parseInt(giorno.oredif);}catch (Exception e) {}
							}
							break;
							
						case INFA:

							t.cod = Giustificativi.INFA.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							if (!oreTotDip.equals("00000") && !giorno.ore.equals(oreTotDip)) {
								try {oreLavorate = Integer.parseInt(giorno.oredif);}catch (Exception e) {}
							}
							break;
						
						case CMT1:

							t.cod = Giustificativi.CMT1.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							if (!oreTotDip.equals("00000") && !giorno.ore.equals(oreTotDip)) {
								try {oreLavorate = Integer.parseInt(giorno.oredif);}catch (Exception e) {}
							}
							break;
							
						case PMNR:

							t.cod = Giustificativi.PMNR.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							if (!oreTotDip.equals("00000") && !giorno.ore.equals(oreTotDip)) {
								try {oreLavorate = Integer.parseInt(giorno.oredif);}catch (Exception e) {}
							}
							break;
						
						case FEGO:

							t.cod = Giustificativi.FEGO.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							if (!oreTotDip.equals("00000") && !giorno.ore.equals(oreTotDip)) {
								try {oreLavorate = Integer.parseInt(giorno.oredif);}catch (Exception e) {}
							}
							break;	
							
						case SOSD:

							t.cod = Giustificativi.SOSD.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							if (!oreTotDip.equals("00000") && !giorno.ore.equals(oreTotDip)) {
								try {oreLavorate = Integer.parseInt(giorno.oredif);}catch (Exception e) {}
							}
							break;
						
						case ORVM:

							t.cod = Giustificativi.ORVM.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							straordinari += Integer.parseInt(giorno.ore);
							
							if (Utils.isLavorativo(i + "/"+mese+"/"+anno)){
							
								oreLavorateS = Integer.parseInt(Utils.getOreDip(cf,ditta));
							}
							
							break;
							
						case SD:

							t.cod = Giustificativi.SD.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							straordinari += Integer.parseInt(giorno.ore);
							
							oreLavorateS = Integer.parseInt(Utils.getOreDip(cf,ditta));
							
							break;
							
						case SDS:

							t.cod = Giustificativi.SDS.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							straordinari += Integer.parseInt(giorno.ore);
							
							break;
							
						case SDF:

							t.cod = Giustificativi.SDF.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							straordinari += Integer.parseInt(giorno.ore);
							
							break;
							
						case ASS0:

							t.cod = Giustificativi.ASS0.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							if (!oreTotDip.equals("00000") && !giorno.ore.equals(oreTotDip)) {
								try {oreLavorate = Integer.parseInt(giorno.oredif);}catch (Exception e) {}
							}
							break;
							
						case ASS1:

							t.cod = Giustificativi.ASS1.getDescBreve();
							t.ore = giorno.ore;
							indice++;
							if (!oreTotDip.equals("00000") && !giorno.ore.equals(oreTotDip)) {
								try {oreLavorate = Integer.parseInt(giorno.oredif);}catch (Exception e) {}
							}
							break;							
						}
						
					} else {
						
						Date _date = formatter.parse(i + "/"+mese+"/"+anno);
						
						if (Utils.isLavorativo(i + "/"+mese+"/"+anno)) {
							
							if ((Festivita.isFestivita(_date) || Festivita.isExFestivita(_date) )
									&& !Utils.isDirigente(cf)) {
								t.cod = Giustificativi.FEGO.getDescBreve();
							} else {
								t.cod = Giustificativi.OL.getDescBreve();
							}
							
							t.ore = "00"+Utils.getOreDip(cf,ditta);
							oredip = Integer.parseInt(Utils.getOreDip(cf,ditta));
						} else {
							
							if ((Festivita.isFestivita(_date) || Festivita.isExFestivita(_date))
									&& !Utils.isDirigente(cf)) {
								if (Utils.isDomenica(i + "/"+mese+"/"+anno)) {
									t.cod = Giustificativi.FENG.getDescBreve();
									t.ore = "00"+Utils.getOreDip(cf, ditta);
									oredip = Integer.parseInt(Utils.getOreDip(cf,ditta));
								} else if (Utils.isSabato(i + "/"+mese+"/"+anno)) {
									t.cod = "  ";
									t.ore = "     ";
								} else {
									t.cod = Giustificativi.FEGO.getDescBreve();
									t.ore = "00"+Utils.getOreDip(cf, ditta);
									oredip = Integer.parseInt(Utils.getOreDip(cf,ditta));
								}
							} else {
								t.cod = "  ";
								t.ore = "     ";
							}

							
						}
					}
				} else {
					if (oreLavorate > 0) {
						t = new Tredicesiomo();
						t.cod = Giustificativi.OL.getDescBreve();
						t.ore = "00"+oreLavorate;
						
						oreLavorate = 0;
						oreLavorateS = 0;
						
					} else if (oreLavorateS > 0) {
						t = new Tredicesiomo();
						t.cod = Giustificativi.OL.getDescBreve();
						t.ore = "00"+oreLavorateS;
						
						oreLavorateS = 0;
					}
				}

				lista.add(t);
			}

			giu.listGiu = lista;
			//int oredip = Integer.parseInt(Utils.getOreDip(cf,ditta));
			
			String _oreLavorate = (oredip + straordinari) >= 1000 ? ""+(oredip + straordinari) : "0" + (oredip + straordinari) ;
			switch (ditta) {
				case "RC10001":
					giu.oreTeoriche = Utils.isLavorativo(i + "/"+mese+"/"+anno) ? _oreLavorate: straordinari == 0 ? "0000" : "0000";//straordinari >=1000 ? ""+straordinari: "0"+(straordinari);
					break;
				default:
					giu.oreTeoriche = oredip == 0 ? "0000" : _oreLavorate;
					break;
			}
			giu.tipoGiorno = Utils.getTipoGiorno(i + "/"+mese+"/"+anno);

			listaGIU.add(giu);

		}
		
		if (listaGIU.size() < dipendente.lung_listGiu) {
			int lunghezza = dipendente.lung_listGiu - listaGIU.size();
			for (int i = 0; i < lunghezza; i++) {
				Giustificativo giu = new Giustificativo();
				List<Tredicesiomo> lista = new ArrayList<Tredicesiomo>();
				for (int j = 0; j < 13; j++) {
					Tredicesiomo t = new Tredicesiomo();
					lista.add(t);
				}
				giu.listGiu = lista;
				giu.oreTeoriche = "0000";
				giu.tipoGiorno = "   " ;
				
				listaGIU.add(giu);
			}
		}

		dipendente.lista = listaGIU;

		dipendente.dataGiuFine = giorniMese+Utils.aggiungiZeri(mese, dipendente.lung_mese)+anno;

		return dipendente;
	}



}
