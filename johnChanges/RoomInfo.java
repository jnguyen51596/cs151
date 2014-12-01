
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author John
 */
public class RoomInfo {

    private int roomNumber;
    private int roomType;
    private ArrayList<String> roomBookingStart= new ArrayList<String>();
    private ArrayList<String> roomBookingEnd= new ArrayList<String>();
    public RoomInfo() {

    }

    public RoomInfo(int number, int type) {
        this.roomNumber = number;
        this.roomType = type;
    }
    
    public void addDate(String startDate, String endDate)
    {
        roomBookingStart.add(startDate);
        roomBookingEnd.add(endDate);
    }
    
    public int getRoomNumber() {
        return roomNumber;
    }

    public int getRoomType() {
        return roomType;
    }
    
    public ArrayList<String> getBookingListStart()
    {
        return roomBookingStart;
    }
    
    public ArrayList<String> getBookingListEnd()
    {
        return roomBookingEnd;
    }
}
