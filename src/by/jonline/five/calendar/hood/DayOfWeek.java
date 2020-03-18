package by.jonline.five.calendar.hood;

public abstract class DayOfWeek {
	
	public static final String MONDAY = "Понедельник";
	public static final String TUESDAY = "Вторник";
	public static final String WENDSDAY = "Среда";
	public static final String THURSDAY = "Четверг";
	public static final String FRIDAY = "Пятница";
	public static final String SATURDAY = "Суббота";
	public static final String SUNDAY = "Воскресенье";

	public static String day(int num) {
		switch (num) {
		case 1: return MONDAY;
		case 2: return TUESDAY;
		case 3: return WENDSDAY;
		case 4: return THURSDAY;
		case 5: return FRIDAY;
		case 6: return SATURDAY;
		case 7: return SUNDAY;
		default: return MONDAY;
		}
		
	}
}
