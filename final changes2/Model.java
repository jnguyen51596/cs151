import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * The model that contains the data for the entire application.
 *
 * @author SJK
 * @version 1.0
 */
public class Model {

    private Calendar cal;
    private String[] months;
    private String[] daysName;
    private ArrayList<String> date;
    private int spaceCounter;
    private String checkIn = "";
    private String checkOut = "";
    private String username;
    private static Database database;
    private static RoomList roomList;
    private ArrayList<ReservationModel> tempReserveList;
    private int tempPrice;
    private Set<String> managerLoginName;
    private Set<String> managerLoginPassword;
    private int receiptChoice = 0;

    private GregorianCalendar gregorianCalendar;
    private ArrayList<String> monthList = new ArrayList<String>();

    private String chosenMonth;

    private Calendar cale;

    private int month;
    private int year;
    private int firstDay;
    private int daysInMonth;
    private int currentDay;
    private final int currentMonth;
    private final int currentYear;

    /**
     * Construct the model.
     */
    public Model() {
        cal = new GregorianCalendar();
        months = new DateFormatSymbols().getMonths();
        daysName = new DateFormatSymbols().getShortWeekdays();
        date = new ArrayList<String>();
        tempReserveList = new ArrayList<ReservationModel>();
        managerLoginName = new TreeSet<String>();
        managerLoginPassword = new HashSet<String>();
        managerLoginName.add("sjk"); // set manager login name
        managerLoginPassword.add("sjk"); // set manager login password

        //Calendar variables
        gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Calendar.DATE, 1);
        month = gregorianCalendar.get(Calendar.MONTH);
        firstDay = gregorianCalendar.get(Calendar.DAY_OF_WEEK) - 1;
        year = gregorianCalendar.get(Calendar.YEAR);

        cale = Calendar.getInstance(TimeZone.getDefault());
        currentDay = cale.get(Calendar.DATE);

        currentMonth = cale.get(Calendar.MONTH);
        currentYear = cale.get(Calendar.YEAR);

        monthList.add("January");
        monthList.add("February");
        monthList.add("March");
        monthList.add("April");
        monthList.add("May");
        monthList.add("June");
        monthList.add("July");
        monthList.add("August");
        monthList.add("September");
        monthList.add("October");
        monthList.add("November");
        monthList.add("December");

        chosenMonth = monthList.get(month);

    }

    /**
     * Add temp choice of receipt.
     *
     * @param num the number
     */
    public void addTempReceiptChoice(int num) {
        receiptChoice = num;
    }

    /**
     * Add the room list to the model.
     *
     * @param roomList the room list
     */
    public void addRoomList(RoomList roomList) {
        this.roomList = roomList;
    }

    /**
     * Add the database to the model.
     *
     * @param database the database
     */
    public void addDatabase(Database database) {
        this.database = database;
    }

    /**
     * Add the check in into the model.
     *
     * @param checkIn the string date
     */
    public void addCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * Add the check out into the model.
     *
     * @param checkOut the string date
     */
    public void addCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * Add the current user.
     *
     * @param username the username
     */
    public void addCurrentUser(String username) {
        this.username = username;
    }

    /**
     * Add the reservation to a temp list.
     *
     * @param m the reservation
     */
    public void addToTempReserveList(ReservationModel m) {
        tempReserveList.add(m);
    }

    /**
     * Add the temp price to the model.
     *
     * @param price the price
     */
    public void addTempPrice(int price) {
        tempPrice = price;
    }

    /**
     * This method return the Months Name in array format
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
        //System.out.println(cal.get(Calendar.MONTH));
        return cal.get(Calendar.MONTH);
    }

    /**
     * Add the receipt choice to model.
     *
     * @return the receipt choice
     */
    public int getReceiptChoice() {
        return receiptChoice;
    }

    /**
     * This method return the current year
     *
     * @return the current year
     */
    public int getCurrentYear() {

        return cal.get(Calendar.YEAR);
    }

    /**
     * Get the days name as an array string.
     *
     * @return the string array
     */
    public String[] getDaysName() {

        return daysName;
    }

    /**
     * Get the current date.
     *
     * @return the current date in a format
     */
    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar in = Calendar.getInstance();
        return dateFormat.format(in.getTime());
    }

    /**
     * Get the date as an arraylist string.
     *
     * @return the arraylist string
     */
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
            date.add("" + day);

            cal.add(Calendar.DAY_OF_MONTH, 1);

        } while (cal.get(Calendar.MONTH) == month);

        do {
            date.add(" ");
        } while (date.size() + spaceCounter != 42);

        return date;

    }

    /**
     * Get the space counter.
     *
     * @return space numbers
     */
    public int getSpaceCounter() {
        return spaceCounter;
    }

    /**
     * Get the checkin date.
     *
     * @return a string date
     */
    public String getCheckIn() {
        return checkIn;
    }

    /**
     * Get the checkout date.
     *
     * @return the string date
     */
    public String getCheckOut() {
        return checkOut;
    }

    /**
     * Get the current username.
     *
     * @return the username
     */
    public String getCurrentUsername() {
        return username;
    }

    /**
     * Get the database.
     *
     * @return the database
     */
    public Database getDatabase() {
        return database;
    }

    /**
     * Get the room list.
     *
     * @return the room list
     */
    public RoomList getRoomList() {
        return roomList;
    }

    /**
     * Get the temp price.
     *
     * @return temp price
     */
    public int getTempPrice() {
        return tempPrice;
    }

    /**
     * Get the temp reservation list.
     *
     * @return the arraylist
     */
    public ArrayList<ReservationModel> getTempReserveList() {
        return tempReserveList;
    }

    /**
     * Set the room list as a string
     *
     * @param list the roominfo list
     * @return the String of the list
     */
    public String setToString(ArrayList<RoomInfo> list) {
        String temp = "";
        for (int i = 0; i < list.size(); i++) {
            temp = temp + "Room number: " + list.get(i).getRoomNumber() + "\n";
        }
        return temp;
    }

    /**
     * Set reservation list to reservation model.
     *
     * @param list the reservation model list
     * @return the String of the list
     */
    public String setAllReservationToString(ArrayList<ReservationModel> list) {
        String temp = "";
        for (int i = 0; i < list.size(); i++) {
            ReservationModel tempRe = list.get(i);
            temp = temp + "Reservation Number: " + tempRe.getTempNum() + "\n";
            temp = temp + "Room number: " + tempRe.getRoomNumber() + "\n";
            temp = temp + "Room Type: $" + tempRe.getRoomType() + "\n";
            temp = temp + "Start Date: " + tempRe.getStartMonth() + "/" + tempRe.getStartDay() + "/" + tempRe.getStartYear() + "\n";
            temp = temp + "End Date: " + tempRe.getEndMonth() + "/" + tempRe.getEndDay() + "/" + tempRe.getEndYear() + "\n";
            temp = temp + " " + "\n";
        }
        return temp;
    }

    /**
     * This method validate manager's username and password
     *
     * @param username manager's login name
     * @param password manager's password
     * @return true, if both user and password are correct, otherwise, false
     */
    public boolean validateManagerLogin(String username, String password) {
        if (managerLoginName.contains(username) && managerLoginPassword.contains(password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Set the month.
     *
     * @param month the month
     */
    public void setMonth(int month) {
        this.month = month;
        chosenMonth = monthList.get(this.month);
        gregorianCalendar.set(Calendar.MONTH, this.month);
        firstDay = gregorianCalendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * Set the year.
     *
     * @param year the year
     */
    public void setYear(int year) {
        this.year = year;
        chosenMonth = monthList.get(this.month);
        gregorianCalendar.set(Calendar.YEAR, this.year);
        gregorianCalendar.set(Calendar.MONTH, this.month);
        firstDay = gregorianCalendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * Reset the month to the original month.
     */
    public void resetMonth() {
        month = currentMonth;
        if (year != currentYear) {
            year = currentYear;
        }
        chosenMonth = monthList.get(month);
        gregorianCalendar.set(Calendar.MONTH, month);
        firstDay = gregorianCalendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * Get the monthlist.
     *
     * @return the monthlist
     */
    public ArrayList<String> getMonthList() {
        return monthList;
    }

    /**
     * Get the amount of days in a month.
     *
     * @param month the month as an integer
     */
    public void getDaysInMonth(int month) {
        int amountOfDays;
        if (month == 1) {
            amountOfDays = 28;
            if (year % 4 == 0) {
                amountOfDays = 29;
            }
        } else {
            amountOfDays = 31;
            if (month == 3 || month == 5 || month == 8 || month == 10) {
                amountOfDays = 30;
            }
        }
        daysInMonth = amountOfDays;
    }

    /**
     * Get the month variable.
     *
     * @return the month as an integer
     */
    public int getMonth() {
        return month;
    }

    /**
     * Get the year variable.
     *
     * @return the year as an integer
     */
    public int getYear() {
        return year;
    }

    /**
     * Get the first day of the month.
     *
     * @return the first day as an integer
     */
    public int getFirstDay() {
        return firstDay;
    }

    /**
     * Get the chosen month for the calendar.
     *
     * @return the chosen month as a String
     */
    public String getChosenMonth() {
        return chosenMonth;
    }

    /**
     * Get the days in month
     *
     * @return the total days
     */
    public int getDaysInMonth() {
        return daysInMonth;
    }

    /**
     * Print the calendar.
     */
    public String printCalenar() {

        getDaysInMonth(month);
        String temp = "";
        temp = temp + " Su  Mo  Tu  We  Th  Fr  Sa" + "\n";

        for (int i = 0; i < firstDay; i++) {
            temp = temp + "      ";
        }
        for (int i = 1; i <= daysInMonth; i++) {
            if ((i + firstDay) % 7 == 0) {
                if (i == currentDay && month == currentMonth && year == currentYear) {
                    temp = temp + " [" + i + "]";
                } else if (i <= 9) {
                    temp = temp + " " + i + " ";
                } else {
                    temp = temp + " " + i + " ";
                }
                temp = temp + "\n";
            } else if (i <= 9) {
                if (i == currentDay && month == currentMonth && year == currentYear) {
                    temp = temp + " [" + i + "]";
                } else {
                    temp = temp + "  " + i + "  ";
                }
            } else {
                if (i == currentDay && month == currentMonth && year == currentYear) {
                    temp = temp + " [" + i + "]";
                } else if (i == currentDay - 1 && month == currentMonth && year == currentYear) {
                    temp = temp + " " + i + " ";
                } else {
                    temp = temp + " " + i + " ";
                }
            }
        }
        return temp;
    }

}
