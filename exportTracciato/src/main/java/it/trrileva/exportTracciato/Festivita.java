package it.trrileva.exportTracciato;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import it.trrileva.exportTracciato.Easter.YearOutOfRangeException;

public class Festivita {
	
	public static boolean isExFestivita(Date data) throws YearOutOfRangeException {
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(data);

		int anno = calendar.get(Calendar.YEAR);
		int mese = calendar.get(Calendar.MONTH);
		int giorno = calendar.get(Calendar.DAY_OF_MONTH);
		switch (mese) {
		case Calendar.NOVEMBER:
			int _giorno = Utils.getFirstSundayNovember(anno);
			
			if (_giorno == giorno)
				return true;

		}
		return false;
		
	}
	
	
	public static boolean isFestivita(Date data) throws YearOutOfRangeException {
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(data);

		int mese = calendar.get(Calendar.MONTH);
		int giorno = calendar.get(Calendar.DAY_OF_MONTH);
		
		switch (mese) {
		case Calendar.JANUARY:
			switch (giorno) {
			case 1:
			case 6:
				return true;
			}
			break;
		case Calendar.MARCH:
			if (Easter.isEaster(data))
				return true;
			break;
		case Calendar.APRIL:
			switch (giorno) {
			case 25:
				return true;
			}
			if (Easter.isEaster(data))
				return true;
			break;
		case Calendar.MAY:
			switch (giorno) {
			case 1:
				return true;
			}
			break;
		case Calendar.JUNE:
			switch (giorno) {
			case 2:
				return true;
			}
			break;
		case Calendar.AUGUST:
			switch (giorno) {
			case 15:
				return true;
			}
			break;
		case Calendar.NOVEMBER:
			switch (giorno) {
			case 1:
				return true;
			}
			break;
		case Calendar.DECEMBER:
			switch (giorno) {
			case 8:
			case 25:
			case 26:
			case 31:
				return true;
			}
			break;
		}
		

		return false;
		
		
	}

}
