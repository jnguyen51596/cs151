import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author John
 */
public class ReservationModel {

    private int startMonth;
    private int startDay;
    private int startYear;

    private int endMonth;
    private int endDay;
    private int endYear;

    private int roomType;
    private int roomNum;
    
    private int guestId;

    public ReservationModel() {

    }

    /**
     * Set the start date of the reservation
     * @param startDate a String , the start date in MM/dd/yyyy format 
     */
    public void addStartDate(String startDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date date1 = sdf.parse(startDate);
            String[] parts = sdf.format(date1).split("/");
            startMonth = Integer.parseInt(parts[0]);
            startDay = Integer.parseInt(parts[1]);
            startYear = Integer.parseInt(parts[2]);
        } catch (ParseException ex) {

        }
    }

    /**
     * Set the end date of the reservation
     * @param endDate a String , the end date in MM/dd/yyyy format
     */
    public void addEndDate(String endDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date date1 = sdf.parse(endDate);
            String[] parts = sdf.format(date1).split("/");
            endMonth = Integer.parseInt(parts[0]);
            endDay = Integer.parseInt(parts[1]);
            endYear = Integer.parseInt(parts[2]);
        } catch (ParseException ex) {

        }
    }

    /**
     * Set the room type for the reservation
     * @param price an int, the room price, which represents the room type
     */
    public void addRoomType(int price) {
        roomType = price;
    }

    /**
     * Set the room number where the reservation has been made
     * @param number an int, the room number
     */
    public void addRoomNumber(int number) {
        roomNum = number;
    }
    
    /**
     * Set the guest ID that made the reservation
     * @param id an int, the guestID
     */
    public void addGuestId(int id)
    {
        guestId=id;
    }
    
    /**
     * Check if the start date and the end date different is not greater than 60
     * @param date1 an String, the start date
     * @param date2 an String, the end date
     * @return 
     */
    public boolean CheckDaysBetweenDates(String date1, String date2) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);
            int days = (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
            if (days <= 60) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException ex) {

        }
        return false;
    }

    /**
     * @return the month when the reservation starts
     */
    public int getStartMonth() {
        return startMonth;
    }

    /**
     * @return the day when the reservation starts 
     */
    public int getStartDay() {
        return startDay;
    }

    /**
     * @return the year when the reservation starts 
     */
    public int getStartYear() {
        return startYear;
    }

    /**
     * @return the month when the reservation ends
     */
    public int getEndMonth() {
        return endMonth;
    }

    /**
     * @return the last day of the reservation
     */
    public int getEndDay() {
        return endDay;
    }

    /** 
     * @return the year when the reservation ends
     */
    public int getEndYear() {
        return endYear;
    }

    /**
     * @return the room type of the reservation
     */
    public int getRoomType() {      
        return roomType;
    }

    /**
     * @return the room number of the reservation 
     */
    public int getRoomNumber() {
        return roomNum;
    }
 
    /**
     * @return the guestID of the Guest who made the reservation
     */
    public int getGuestId()
    {
        return guestId;
    }
}
