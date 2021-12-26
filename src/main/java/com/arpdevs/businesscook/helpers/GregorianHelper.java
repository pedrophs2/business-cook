package com.arpdevs.businesscook.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Service;

@Service
public class GregorianHelper {

	public GregorianHelper() {
	}

	public String printGregorianCalendar(GregorianCalendar date) throws Exception {

		String convertedDate;

		if (date == null) {
			throw new Exception("Data inválida");
		} else {
			convertedDate = date.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (date.get(GregorianCalendar.MONTH) + 1)
					+ "/" + (date.get(GregorianCalendar.YEAR)) + " " + date.get(GregorianCalendar.HOUR_OF_DAY) + ":"
					+ date.get(GregorianCalendar.MINUTE) + ":" + date.get(GregorianCalendar.SECOND);
		}

		return convertedDate;
	}

	public void debugGregorianCalendar(GregorianCalendar date) throws Exception {

		if (date == null) {
			throw new Exception("Data inválida");
		} else {
			System.out.println("Dia: " + date.get(GregorianCalendar.DAY_OF_MONTH));
			System.out.println("Mês: " + (date.get(GregorianCalendar.MONTH) + 1));
			System.out.println("Ano: " + date.get(GregorianCalendar.YEAR));
			System.out.println("Hora: " + date.get(GregorianCalendar.HOUR_OF_DAY));
			System.out.println("Minuto: " + date.get(GregorianCalendar.MINUTE));
			System.out.println("Segundo: " + date.get(GregorianCalendar.SECOND));
		}
	}

	public GregorianCalendar stringToCalendar(String strDate, String format) throws Exception {
		GregorianCalendar dt = new GregorianCalendar();

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = formatter.parse(strDate);

		dt.setTimeInMillis(date.getTime());

		return dt;
	}

}
