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

    public ArrayList<RoomInfo> checkRoom(String date1, String date2) {

        int startMonthDate1 = 0;
        int startDayDate1 = 0;
        int startYearDate1 = 0;

        int endMonthDate2 = 0;
        int endDayDate2 = 0;
        int endYearDate2 = 0;

        ArrayList<RoomInfo> availableRoom = new ArrayList<RoomInfo>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date startDate = sdf.parse(date1);
            String[] parts1 = sdf.format(startDate).split("/");
            startMonthDate1 = Integer.parseInt(parts1[0]);
            startDayDate1 = Integer.parseInt(parts1[1]);
            startYearDate1 = Integer.parseInt(parts1[2]);

        } catch (ParseException ex) {

        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date endDate = sdf.parse(date2);
            String[] parts2 = sdf.format(endDate).split("/");
            endMonthDate2 = Integer.parseInt(parts2[0]);
            endDayDate2 = Integer.parseInt(parts2[1]);
            endYearDate2 = Integer.parseInt(parts2[2]);

        } catch (ParseException ex) {

        }
        for (int i = 0; i < roomList.size(); i++) {

            RoomInfo temp = roomList.get(i);
            int count = 0;
            for (int j = 0; j < temp.getBookingListStart().size(); j++) {

                int startMonthRoom = 0;
                int startDayRoom = 0;
                int startYearRoom = 0;

                int endMonthRoom = 0;
                int endDayRoom = 0;
                int endYearRoom = 0;
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    Date startDateRoom = sdf.parse(temp.getBookingListStart().get(j));
                    String[] parts3 = sdf.format(startDateRoom).split("/");
                    startMonthRoom = Integer.parseInt(parts3[0]);
                    startDayRoom = Integer.parseInt(parts3[1]);
                    startYearRoom = Integer.parseInt(parts3[2]);

                } catch (ParseException ex) {

                }
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    Date endDateRoom = sdf.parse(temp.getBookingListEnd().get(j));
                    String[] parts4 = sdf.format(endDateRoom).split("/");
                    endMonthRoom = Integer.parseInt(parts4[0]);
                    endDayRoom = Integer.parseInt(parts4[1]);
                    endYearRoom = Integer.parseInt(parts4[2]);

                } catch (ParseException ex) {

                }
                if (startMonthDate1 < startMonthRoom) {
                    if (endMonthDate2 < endMonthRoom) {
                    } else if (endMonthDate2 == endMonthRoom) {
                        if (endDayDate2 < endDayRoom) {
                            count++;
                        } else if (endDayDate2 == endDayRoom) {
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else if (startMonthDate1 == startMonthRoom) {
                    if (startDayDate1 < startDayRoom) {
                        if (endDayDate2 < startDayRoom) {
                            count++;
                        } else {
                            break;
                        }
                    } else if (startDayDate1 > endDayRoom) {
                        count++;
                    } else {
                        break;
                    }
                } else if (startMonthDate1 > startMonthRoom) {
                    if (endMonthDate2 < startMonthRoom) {
                        count++;
                    } else if (endMonthDate2 == startMonthRoom) {
                        if (endDayDate2 < startDayRoom) {
                        } else {
                            break;
                        }
                    }
                } else {

                }

                if (count == temp.getBookingListStart().size()) {
                    availableRoom.add(temp);
                }
            }
        }

        return availableRoom;
    }

}
