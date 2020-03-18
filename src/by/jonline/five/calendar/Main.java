package by.jonline.five.calendar;

import by.jonline.five.calendar.hood.Calendar;
import by.jonline.five.calendar.hood.Period;

public class Main {
	
	public static void main(String[] args) {
		Calendar c = new Calendar(16, 10, 1582);
		Calendar b = new Calendar(16, 10, 2582);
		c.addHoliday("выходной", Period.YEAR);
		//c.printDate();
		b.printDate();
	}
	
	
}
