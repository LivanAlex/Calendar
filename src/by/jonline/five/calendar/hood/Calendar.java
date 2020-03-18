package by.jonline.five.calendar.hood;

import java.util.HashSet;

public class Calendar {
	
	private int day;
	private int month;
	private int year;
	private int dayOfWeek;
	
	private static HashSet <Holiday> holidays;
	
	public Calendar(int day, int month, int year) {
		this.year = year;
		this.month = monthCheck(month);
		this.day = dayCheck(day, month, year);
		
		gregorianCheck(day, month, year);
		
		dayOfWeek = dayOfWeek(this.day, this.month, this.year);
	}
	
	
	// 15 октября 1582 года - старт Григорианского календаря
	private void gregorianCheck(int day, int month, int year) {
		if (year < 1582) {
			this.year = 1582;
			this.month = 10;
			this.day = 15;
			if(month < 10) {
				this.month = 10;
				this.day = 15;
			} else if (month == 10) {
				if (day < 15) {
					this.day = 15;
				}
			}
		}	
	}
	
	public int getDay() {
		return day;
	}


	public int getMonth() {
		return month;
	}


	public int getDayOfWeek() {
		return dayOfWeek;
	}


	public void printDate() {
		System.out.printf("%s %d.%02d.%d", DayOfWeek.day(dayOfWeek), day, month, year);
		
		for (Holiday holiday : holidays) {
			if(holiday.getPeriod() == Period.YEAR) {
				CalendarByDayMonthComparator comp = new CalendarByDayMonthComparator();
				if (comp.compare(this, holiday.getDate()) == 0) {
					System.out.print(holiday.getName());
				}
			}
		}
		
		
	}
	
	public void addHoliday(String name, Period period) {
		if (holidays == null) {
			holidays = new HashSet<>();
		}
		holidays.add(new Holiday(this, name, period));
	}
	
	private int dayCheck(int day, int month, int year) {
		int maxDay = dayInMonth(month, year);
		if (day > 0 && day <= maxDay) {
			return day;
		} else {
			return 1;
		}
	}
	
	private int monthCheck(int month) {
		if (month > 0 && month < 13) {
			return month;
		} else {
			return 1;
		}
	}
	
	private int dayOfWeek(int day, int month, int year) {
		if(month < 3) {
			--year;
			month += 10;
		} else {
			month -= 2;
		}
		return (day + (31 * month) / 12 + year + year / 4 - year / 100 + year / 400) % 7;
	}
	
	private int dayInMonth(int month, int year) {
		
		int dayInMonth;
		int a;
		int b;
		int c;
		
		a = year % 4 + 1;
		b = year % 100 + 1;
		c = year % 400 + 1;
		
		dayInMonth = (int) (28 + ((month + Math.floor(month / 8)) % 2) + 2 % month
				+ Math.floor((1 + (1 - (a + 1) % a) * ((b + 1) % b)
						+ (1 - (c+1) % c)) / month)
				+ Math.floor(1/month) - Math.floor(((1 - (a + 1) % a) * ((b + 1) % b)
						+ (1 - (c+1) % c)) / month));
		
		return dayInMonth;
	}	
}

class Holiday {
	private Calendar date;
	private String name;
	private Period period;
	
	public Holiday(Calendar date, String name, Period period) {
		this.date = date;
		this.name = name;
		this.period = period;
	}

	public Calendar getDate() {
		return date;
	}
	
	public String getName() {
		return name;
	}

	public Period getPeriod() {
		return period;
	}
}
