package datatype;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import exceptions.IllegalDateException;

public record DateType() {
	
	public DateType() {
	}
		
	
	public String getCurrentDate() {
		LocalDate currentdate = LocalDate.now();
		int currentDay = currentdate.getDayOfMonth();
		Month currentMonth = currentdate.getMonth();
		int currentYear = currentdate.getYear();
		return currentDay + " " + currentMonth + " " + currentYear;
	}
	
}
