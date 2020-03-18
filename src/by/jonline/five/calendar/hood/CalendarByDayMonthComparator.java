package by.jonline.five.calendar.hood;

import java.util.Comparator;

public class CalendarByDayMonthComparator implements Comparator<Calendar> {

	@Override
	public int compare(Calendar o1, Calendar o2) {
		if(o1.getMonth() < o2.getMonth()) {
			return -1;
		} else if (o1.getMonth() == o2.getMonth()) {
			if (o1.getDay() < o2.getDay()) {
				return -1;
			} else if (o1.getDay() == o2.getDay()) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}

}
