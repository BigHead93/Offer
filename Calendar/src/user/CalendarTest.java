package user;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest 
{
/**
 * @author I317032
 * @param args
 */
	public static void main(String[] args) 
	{

		final GregorianCalendar d = new GregorianCalendar();
		
		/**
		 * today: current day
		 * month: current month
		 * set d as the first day of current month
		 */
		int today = d.get(Calendar.DAY_OF_MONTH);  
		int month = d.get(Calendar.MONTH);			
		
		d.set(Calendar.DAY_OF_MONTH,1);        
		
		int weekday = d.get(Calendar.DAY_OF_WEEK);  
		int firstDayOfWeek = d.getFirstDayOfWeek();  
		
		/**
		 * weekday: week of the first day
		 * firstDayOfWeek: local calendar, first day of a week
		 * if weekday != firstDayOfWeek, set indent
		 */
		int indent = 0;
		while(weekday != firstDayOfWeek)
		{
			indent++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}
		
		/**
		 * output section
		 */
		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		
		do
		{
			System.out.printf("%4s", weekdayNames[weekday]);
			d.add(Calendar.DAY_OF_MONTH,1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}while(weekday != firstDayOfWeek);
		
		System.out.println();
		
		for(int i = 0; i < indent; i ++)
			System.out.print("    ");
		
		d.set(Calendar.DAY_OF_MONTH, 1);
		do
		{
			int day = d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);
			
			if(day == today){ System.out.print("*");}
			else			 {System.out.print(" ");}
			
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
			
			if(weekday == firstDayOfWeek) System.out.println();
			
		}
		
		while(d.get(Calendar.MONTH)== month);
		
		if(weekday != firstDayOfWeek) System.out.println();
		
	}

}
