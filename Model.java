import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Model 
{
	private Calendar cal;
	private String [] months;
	private String [] daysName;
	private ArrayList<String> date ;
	private int spaceCounter;
	public Model()
	{
		cal = new GregorianCalendar();
		months =new DateFormatSymbols().getMonths();
		daysName = new DateFormatSymbols().getShortWeekdays();
		date = new ArrayList<String>();
			
	}
	
	
/**
 * 	This method return  the Months' Name in array format
 * @return the months array
 */
	public String [] getMonths()
	{
			return months;
	}
	
	
/**
 * This method return the current month 
 * @return the current month
 */
	public int getCurrentMonth()
	{
		System.out.println(cal.get(Calendar.MONTH));
		 return cal.get(Calendar.MONTH);
	}
	

	/**
	 * This method return the current year
	 * @return the current year
	 */
	public int getCurrentYear() 
	{
		
		return  cal.get(Calendar.YEAR);
	}
	


	public String[] getDaysName() 
	{
		
		return daysName;
	}
	
	public ArrayList<String>  getDate()
	{
		
		   
		
			 int  month = cal.get(Calendar.MONTH);
			
			
			 
			 cal.set(Calendar.DAY_OF_MONTH, 1);
			 int   dayNameNumber = cal.get(Calendar.DAY_OF_WEEK);
			 int  firstDayNumberofweek = cal.getFirstDayOfWeek();// get Sunday
			 int  counter = dayNameNumber - firstDayNumberofweek;
			 spaceCounter =counter;
			 cal.set(Calendar.DAY_OF_MONTH,1);
			 do
			 {
				 int day = cal.get(Calendar.DAY_OF_MONTH);
				 System.out.println(day+"this is day");
				 date.add(""+day);
				 
				  cal.add(Calendar.DAY_OF_MONTH, 1);
				 
			} while(cal.get(Calendar.MONTH )== month);
			
			 do
			 {
				 date.add(" ");
			 }while(date.size()+spaceCounter !=42);
			 
		return date;
			
		}

	public int getSpaceCounter()
	{
		return spaceCounter;
	}
	
	/**
 * This method validate manager's username and password 
 * @param username manager's login name
 * @param password manager's password
 * @return true, if both user and password are correct, otherwise, false
 */

public boolean validateManagerLogin(String username, String password)
{
	if(managerLoginName.contains(username) && managerLoginPassword.contains(password) )
	{
		return true;
	}
	else
	return false;
}
	
	
	
}
