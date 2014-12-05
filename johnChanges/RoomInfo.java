
import java.util.ArrayList;
import java.util.Date;

/**
 * Room Info class contructs the room info object and provides method to retrieve
 * information about the room
 * @author John
 */
public class RoomInfo {

    private int roomNumber;
    private int roomType;
    private ArrayList<String> roomBookingStart= new ArrayList<String>();
    private ArrayList<String> roomBookingEnd= new ArrayList<String>();
    
    public RoomInfo() {

    }

    /**
     * Constructs a RoomInfo object with the room number and the room type
     * @param number, an int, room number
     * @param type  an int, room type
     */
    public RoomInfo(int number, int type) {
        this.roomNumber = number;
        this.roomType = type;
    }
    
    /**
     * Book the room for a certain date
     * @param startDate an String, start date that the room will be booked
     * @param endDate  an String, end date 
     */
    public void addDate(String startDate, String endDate)
    {
        roomBookingStart.add(startDate);
        roomBookingEnd.add(endDate);
    }
    
    /**
     * @return the room number 
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @return the room type 
     */
    public int getRoomType() {
        return roomType;
    }
    
    /**
     * @return an arraylist with all the start dates that the room was booked 
     */
    public ArrayList<String> getBookingListStart()
    {
        return roomBookingStart;
    }
    
    /**
     * @return an arraylist with all the end dates that the room was booked 
     */
    public ArrayList<String> getBookingListEnd()
    {
        return roomBookingEnd;
    }
}
