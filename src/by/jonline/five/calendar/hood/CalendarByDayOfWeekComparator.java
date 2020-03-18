package by.jonline.five.calendar.hood;

import java.util.Comparator;

public class CalendarByDayOfWeekComparator implements Comparator<Calendar> {

	@Override
	public int compare(Calendar o1, Calendar o2) {
		return o1.getDayOfWeek() - o2.getDayOfWeek();
	}

}
