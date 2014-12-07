import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The reservation data for a reservation.
 *
 * @author SJK
 * @version 1.0
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

    private String guestId;

    private int tempNum;

    /**
     * Construct the reservation model.
     */
    public ReservationModel() {

    }

    /**
     * Add the start date.
     *
     * @param startDate the string date
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
     * Add the end date.
     *
     * @param endDate the string end date
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
     * Add the room type.
     *
     * @param price the price
     */
    public void addRoomType(int price) {
        roomType = price;
    }

    /**
     * Add the room number.
     *
     * @param number the room number
     */
    public void addRoomNumber(int number) {
        roomNum = number;
    }

    /**
     * Add the guest id to the reservation.
     *
     * @param id the id
     */
    public void addGuestId(String id) {
        guestId = id;
    }

    /**
     * Add the temp number for the deletion.
     *
     * @param num the number
     */
    public void addTempNum(int num) {
        tempNum = num;
    }

    /**
     * Check the days between to dates.
     *
     * @param date1 the start date string
     * @param date2 the end date string
     * @return true if days is less than 60 days else false
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
     * Get the start date month.
     *
     * @return the month
     */
    public int getStartMonth() {
        return startMonth;
    }

    /**
     * Get the start date day.
     *
     * @return the day
     */
    public int getStartDay() {
        return startDay;
    }

    /**
     * Get the start date year.
     *
     * @return the year
     */
    public int getStartYear() {
        return startYear;
    }

    /**
     * Get the end date month.
     *
     * @return the month
     */
    public int getEndMonth() {
        return endMonth;
    }

    /**
     * Get the end date day.
     *
     * @return the day
     */
    public int getEndDay() {
        return endDay;
    }

    /**
     * Get the end date year.
     *
     * @return the year
     */
    public int getEndYear() {
        return endYear;
    }

    /**
     * Get the room type.
     *
     * @return the room type
     */
    public int getRoomType() {
        return roomType;
    }

    /**
     * Get the room number.
     *
     * @return the room number
     */
    public int getRoomNumber() {
        return roomNum;
    }

    /**
     * Get the guest id.
     *
     * @return the guest id
     */
    public String getGuestId() {
        return guestId;
    }

    /**
     * Get the temp number.
     *
     * @return the temp number
     */
    public int getTempNum() {
        return tempNum;
    }
}
