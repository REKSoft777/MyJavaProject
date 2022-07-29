import java.util.Date;
import java.util.Calendar;

public class Time {

	
	
	
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		Date date= new Date();
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minutes = cal.get(Calendar.MINUTE);
		if (hour == 16 && minutes >= 30 || hour == 17 && minutes <= 30) {
		   System.out.println(date);
		}
	}

}
