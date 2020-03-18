package by.jonline.five.calendar;

import by.jonline.five.calendar.hood.Calendar;
import by.jonline.five.calendar.hood.Period;

public class Main {
	
	public static void main(String[] args) {
		Calendar saturday = new Calendar(16, 10, 1582);
		Calendar sanday = new Calendar(17, 10, 1582);
		Calendar wictoryDay = new Calendar(9, 05, 1945);
		
		saturday.addHoliday("выходной", Period.WEEK);
		sanday.addHoliday("выходной" , Period.WEEK);
		wictoryDay.addHoliday("День победы", Period.YEAR);
		
		Calendar[] checkWeek = new Calendar[7];
		for (int i = 0; i < 7; i++) {
			checkWeek[i] = new Calendar(7+i, 05, 2020);
			checkWeek[i].printDate();
		}

	}
	
	
}
