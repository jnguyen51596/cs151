import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public void addRoomType(int price) {
        roomType = price;
    }

    public void addRoomNumber(int number) {
        roomNum = number;
    }
    
    public void addGuestId(int id)
    {
        guestId=id;
    }
    
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

    public int getStartMonth() {
        return startMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public int getEndYear() {
        return endYear;
    }

    public int getRoomType() {      
        return roomType;
    }

    public int getRoomNumber() {
        return roomNum;
    }
    
    public int getGuestId()
    {
        return guestId;
    }
}
