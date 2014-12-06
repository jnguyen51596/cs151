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
import java.util.TreeSet;

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

    }

    public void addTempReceiptChoice(int num) {
        receiptChoice = num;
    }

    public void addRoomList(RoomList roomList) {
        this.roomList = roomList;
    }

    public void addDatabase(Database database) {
        this.database = database;
    }

    public void addCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public void addCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public void addCurrentUser(String username) {
        this.username = username;
    }

    public void addToTempReserveList(ReservationModel m) {
        tempReserveList.add(m);
    }

    public void addTempPrice(int price) {
        tempPrice = price;
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

    public String[] getDaysName() {

        return daysName;
    }
    public String getCurrentDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar in=Calendar.getInstance();
        return dateFormat.format(in.getTime());
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

    public String getCurrentUsername() {
        return username;
    }

    public Database getDatabase() {
        return database;
    }

    public RoomList getRoomList() {
        return roomList;
    }

    public int getTempPrice() {
        return tempPrice;
    }

    public ArrayList<ReservationModel> getTempReserveList() {
        return tempReserveList;
    }

    public String setToString(ArrayList<RoomInfo> list) {
        String temp = "";
        for (int i = 0; i < list.size(); i++) {
            temp = temp + "Room number: " + list.get(i).getRoomNumber() + "\n";
        }
        return temp;
    }
    
    public String setAllReservationToString(ArrayList<ReservationModel> list) {
        String temp = "";
        for (int i = 0; i < list.size(); i++) {
            ReservationModel tempRe=list.get(i);
            temp = temp + "Reservation Number: "+tempRe.getTempNum()+"\n";
            temp = temp + "Room number: " + tempRe.getRoomNumber() + "\n";
            temp = temp + "Room Type: $" + tempRe.getRoomType() + "\n";
            temp = temp + "Start Date: " + tempRe.getStartMonth() + "/" + tempRe.getStartDay() + "/" + tempRe.getStartYear() + "\n";
            temp = temp + "End Date: " + tempRe.getEndMonth() + "/" + tempRe.getEndDay() + "/" + tempRe.getEndYear() + "\n";
            temp = temp +" "+ "\n";
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

}
