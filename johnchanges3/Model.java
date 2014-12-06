import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Model {

    private Calendar cal;
    private String[] months;
    private String[] daysName;
    private ArrayList<String> date;
    private int spaceCounter;
    private String checkIn="";
    private String checkOut="";
    private String username;

    public Model() {
        cal = new GregorianCalendar();
        months = new DateFormatSymbols().getMonths();
        daysName = new DateFormatSymbols().getShortWeekdays();
        date = new ArrayList<String>();

    }

    public void addCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public void addCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
    
    public void addCurrentUser(String username)
    {
        this.username=username;
    }
    /**
     * This method return the Months' Name in array format
     *
     * @return the months array
     */
    public String[] getMonths() {
        return months;
    }

    /**
     * This method return the current month
     *
     * @return the current month
     */
    public int getCurrentMonth() {
        System.out.println(cal.get(Calendar.MONTH));
        return cal.get(Calendar.MONTH);
    }

    /**
     * This method return the current year
     *
     * @return the current year
     */
    public int getCurrentYear() {

        return cal.get(Calendar.YEAR);
    }

    public String[] getDaysName() {

        return daysName;
    }

    public ArrayList<String> getDate() {

        int month = cal.get(Calendar.MONTH);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        int dayNameNumber = cal.get(Calendar.DAY_OF_WEEK);
        int firstDayNumberofweek = cal.getFirstDayOfWeek();// get Sunday
        int counter = dayNameNumber - firstDayNumberofweek;
        spaceCounter = counter;
        cal.set(Calendar.DAY_OF_MONTH, 1);
        do {
            int day = cal.get(Calendar.DAY_OF_MONTH);
            System.out.println(day + "this is day");
            date.add("" + day);

            cal.add(Calendar.DAY_OF_MONTH, 1);

        } while (cal.get(Calendar.MONTH) == month);

        do {
            date.add(" ");
        } while (date.size() + spaceCounter != 42);

        return date;

    }

    public int getSpaceCounter() {
        return spaceCounter;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public String getUsername()
    {
        return username;
    }
    public String setToString(ArrayList<RoomInfo> list) {
        String temp = "";
        for (int i = 0; i < list.size(); i++) {
            temp = temp + "Room number: " + list.get(i).getRoomNumber() + "\n";
        }
        return temp;
    }

}
