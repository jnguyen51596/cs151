import java.util.ArrayList;
import java.util.Date;

/**
 * The room information for the list.
 *
 * @author SJK
 * @version 1.0
 */
public class RoomInfo {

    private int roomNumber;
    private int roomType;
    private ArrayList<String> roomBookingStart = new ArrayList<String>();
    private ArrayList<String> roomBookingEnd = new ArrayList<String>();

    public RoomInfo() {

    }

    /**
     * Construct the room info.
     *
     * @param number the room number
     * @param type the room type
     */
    public RoomInfo(int number, int type) {
        this.roomNumber = number;
        this.roomType = type;
    }

    /**
     * Add the date to the room.
     *
     * @param startDate the start date
     * @param endDate the end date
     */
    public void addDate(String startDate, String endDate) {
        roomBookingStart.add(startDate);
        roomBookingEnd.add(endDate);
    }

    /**
     * Get the room number.
     *
     * @return the room number
     */
    public int getRoomNumber() {
        return roomNumber;
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
     * Get the booking list start date.
     *
     * @return the start date
     */
    public ArrayList<String> getBookingListStart() {
        return roomBookingStart;
    }

    /**
     * Get the booking list end date.
     *
     * @return the end date
     */
    public ArrayList<String> getBookingListEnd() {
        return roomBookingEnd;
    }
}
