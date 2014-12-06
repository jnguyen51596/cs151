import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class RoomList {

    private ArrayList<RoomInfo> roomList = new ArrayList<RoomInfo>();

    public RoomList() {
        roomList.add(new RoomInfo(1, 100));
        roomList.add(new RoomInfo(2, 100));
        roomList.add(new RoomInfo(3, 100));
        roomList.add(new RoomInfo(4, 100));
        roomList.add(new RoomInfo(5, 100));
        roomList.add(new RoomInfo(6, 100));
        roomList.add(new RoomInfo(7, 100));
        roomList.add(new RoomInfo(8, 100));
        roomList.add(new RoomInfo(9, 100));
        roomList.add(new RoomInfo(10, 100));

        roomList.add(new RoomInfo(11, 200));
        roomList.add(new RoomInfo(12, 200));
        roomList.add(new RoomInfo(13, 200));
        roomList.add(new RoomInfo(14, 200));
        roomList.add(new RoomInfo(15, 200));
        roomList.add(new RoomInfo(16, 200));
        roomList.add(new RoomInfo(17, 200));
        roomList.add(new RoomInfo(18, 200));
        roomList.add(new RoomInfo(19, 200));
        roomList.add(new RoomInfo(20, 200));
    }

    public void addBookingDatesToRoom(Database database) {
        for (int i = 0; i < database.getReservationListFromDatabase().size(); i++) {
            int startMonth = database.getReservationListFromDatabase().get(i).getStartMonth();
            int startDay = database.getReservationListFromDatabase().get(i).getStartDay();
            int startYear = database.getReservationListFromDatabase().get(i).getStartYear();

            int endMonth = database.getReservationListFromDatabase().get(i).getEndMonth();
            int endDay = database.getReservationListFromDatabase().get(i).getEndDay();
            int endYear = database.getReservationListFromDatabase().get(i).getEndYear();

            String startDate = startMonth + "/" + startDay + "/" + startYear;
            String endDate = endMonth + "/" + endDay + "/" + endYear;

            int roomNum = database.getReservationListFromDatabase().get(i).getRoomNumber();
            int roomType = database.getReservationListFromDatabase().get(i).getRoomType();

            for (int j = 0; j < roomList.size(); i++) {
                if (roomList.get(i).getRoomNumber() == roomNum && roomList.get(i).getRoomType() == roomType) {
                    roomList.get(i).addDate(startDate, endDate);
                    break;
                }
            }
        }
    }

    public ArrayList<RoomInfo> checkRoom(String date1, String date2, int roomType) {

        SimpleDateFormat sdf;
        Date startDate = null;
        Date endDate = null;
        ArrayList<RoomInfo> availableRoom = new ArrayList<RoomInfo>();
        try {
            sdf = new SimpleDateFormat("MM/dd/yyyy");
            startDate = sdf.parse(date1);
            endDate = sdf.parse(date2);

        } catch (ParseException ex) {

        }
        for (int i = 0; i < roomList.size(); i++) {//check the room list
            RoomInfo temp = roomList.get(i);
            if (temp.getRoomType() != roomType) {
                continue;
            }
            int count = 0;
            for (int j = 0; j < temp.getBookingListStart().size(); j++) {//check bookings in room
                String stringStartDate = temp.getBookingListStart().get(j);
                String stringEndDate = temp.getBookingListEnd().get(j);
                Date roomStartDate = null;
                Date roomEndDate = null;
                try {
                    sdf = new SimpleDateFormat("MM/dd/yyyy");
                    roomStartDate = sdf.parse(stringStartDate);
                    roomEndDate = sdf.parse(stringEndDate);

                } catch (ParseException ex) {
                }

                if (startDate.after(roomStartDate) && startDate.before(roomEndDate)) {
                    break;
                } else if (startDate.after(roomStartDate) && startDate.after(roomEndDate)) {
                    count++;
                } else {
                    if (endDate.before(roomStartDate)) {
                        break;
                    } else {
                        count++;
                    }
                }

            }
            if (count == temp.getBookingListStart().size()) {
                availableRoom.add(temp);
                count = 0;
            }

        }

        return availableRoom;
    }
    
}
