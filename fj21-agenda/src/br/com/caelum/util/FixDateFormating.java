package br.com.caelum.util;

import java.sql.Date;
import java.util.Calendar;

public class FixDateFormating {
	
	public static Calendar setDateToCalendar(Date date){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar;
	}
	
	public static Date setCalendarToDate(Calendar calendar){
		Long dateInMillis = calendar.getTimeInMillis();
		Date date = new Date(dateInMillis);
		return date; 
	}

}
