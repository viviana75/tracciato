package it.trrileva.exportTracciato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import it.trrileva.exportTracciato.Easter.YearOutOfRangeException;

public class Utils {

	public static String getOreDip(String cf, String ditta) {
		// part-time 7,40, i dipendenti sono Cantoni, D’Ottavi, Perrone, Ronconi, Renzi  e Sottile;
		switch (ditta) {
			case "RC10001":
				if (cf.equalsIgnoreCase("CNTMNL79A65H501L") || cf.equalsIgnoreCase("DTTMLS63R62H501B")
						|| cf.equalsIgnoreCase("PRRFNC76E58F611C") || cf.equalsIgnoreCase("RNCDNL78B58H501Z")
						|| cf.equalsIgnoreCase("RNZLRA70P44H501M") || cf.equalsIgnoreCase("STTRSR79D70H703H")) {
					return "740";
				} else if (cf.equalsIgnoreCase("MLSMNG67D63F205O")) {
					return "600";
				} else {
					return "800";
				}

			default:
				return "000";
		}


	}
	
	
//	Ditta Celiachiamo.com   RC11010
//
//	PT Ottaviani e Caprioli come si evidenzia dalle presenze l’orario varia da settimana a settimana.
//
//	 
//
//	Buonaidea  RC10009
//
//	Dipendenti PT
//
//	Martini Laura lavora dal martedì alla domenica 4 ore al giorno
//
//	Landoni l’orario varia da settimana a settimana
//
//	Violo lavora dal lunedì al sabato 4 ore al giorno ( possibile variazione durante il mese)
//
//	Tripodi lavora dal mercoledì /giovedì 6 ore venerdì 4 ore sabato 8 ore  8possibile variazione durante il mese)
//
//	 
//
//	Daconaco   RC10059
//
//	Dipendenti PT
//
//	Di Ceglie si evidenzia dalle presenze l’orario varia da settimana a settimana
//
//	Muciaccia lavora dal martedì al venerdì 4 ore e il sabato 8 ore
//
//	Sammarini lavora dal martedì al venerdì 4 ore e il sabato 8 ore.
//
//	 
//
//	Compracompra   RC11011
//
//	Dipendente PT
//
//	De Blasis Franca dal lunedì al venerdì 6 ore.
	
	public static boolean isDirigente (String cf) {
		
		if (cf.equalsIgnoreCase("BNCBFC66E30H501K")  
				|| cf.equalsIgnoreCase("BNCMRA65B65H501T")  
			) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isLavorativo(String data) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date _date = formatter.parse(data);

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(_date);
		int dow = calendar.get(Calendar.DAY_OF_WEEK);

		switch (dow) {
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			// feriale
			return true;
		case 7:
			// sabato
		case 1:
			// domenica
			return false;
		}
		return true;

	}
	
	public static boolean isSabato(String data) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date _date = formatter.parse(data);

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(_date);
		int dow = calendar.get(Calendar.DAY_OF_WEEK);

		switch (dow) {
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			return false;
		case 7:
			// sabato
			return true;
		case 1:
			// domenica
			return false;
		}
		return true;

	}
	
	public static boolean isDomenica(String data) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date _date = formatter.parse(data);

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(_date);
		int dow = calendar.get(Calendar.DAY_OF_WEEK);

		switch (dow) {
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			// sabato
			return false;
		case 1:
			// domenica
			return true;
		}
		return true;

	}

	public static int giorniMese(int year, int month) {
		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		return daysInMonth;
	}

	public static String getTipoGiorno(String data) throws ParseException, YearOutOfRangeException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date _date = formatter.parse(data);

		// festivo
		if ((Festivita.isFestivita(_date) || Festivita.isExFestivita(_date) ))
			return "FES";

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(_date);
		int dow = calendar.get(Calendar.DAY_OF_WEEK);

		switch (dow) {
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			// feriale
			return "FER";
		case 7:
			// pre riposo
			return "PRI";
		case 1:
			// riposo
			return "RIP";
		}

		return "FER";

	}

	public static String aggiungiSpazi(String str, int size) {

		return String.format("%-" + size + "s", str);
	}

	public static String aggiungiZeri(String str, int size) {

		return String.format("%0" + size + "d", Integer.parseInt(str));
	}

	private static Calendar cacheCalendar = new GregorianCalendar();

	private static int getFirstSunday(int year, int month) {
		cacheCalendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
		cacheCalendar.set(Calendar.MONTH, month);
		cacheCalendar.set(Calendar.YEAR, year);
		return cacheCalendar.get(Calendar.DATE);
	}

	public static int getFirstSundayNovember(int year) {
		return getFirstSunday(year, Calendar.NOVEMBER);
	}

}
