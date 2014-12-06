import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author John
 */
public class Database {

    ArrayList<Guest> guestList = new ArrayList<Guest>();
    ArrayList<ReservationModel> reservationList = new ArrayList<ReservationModel>();
    File file = new File("/Users/John/Desktop/reservation2.txt");
    File file2 = new File("/Users/John/Desktop/guest.txt");

    public Database() {

    }

    public void addGuestList (Guest g)
    {
        guestList.add(g);
    }
    public void addReservationToDatabase(ReservationModel r) {
        reservationList.add(r);
    }
    
    public ArrayList<Guest> getGuestListFromDatabase()
    {
        return guestList;
    }
    
    public ArrayList<ReservationModel> getReservationListFromDatabase()
    {
        return reservationList;
    }
    
    public void writeToGuestFile() throws FileNotFoundException {
        String firstname;
        String lastname;
        String username;
        String bdate1;
        String bdate2;
        String bdate3;
        String password;

        try {
            FileWriter fw = new FileWriter(file2);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(file2);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < guestList.size(); i++) {
                firstname = guestList.get(i).getFirstName();
                lastname = guestList.get(i).getLastName();
                username = guestList.get(i).getUsername();
                bdate1 = guestList.get(i).getBdate1();
                bdate2 = guestList.get(i).getBdate2();
                bdate3 = guestList.get(i).getBdate3();
                password = guestList.get(i).getPassword();
                if (!file2.exists()) {
                    file2.createNewFile();
                }

                bw.write(firstname);
                bw.newLine();
                bw.write(lastname);
                bw.newLine();
                bw.write(username);
                bw.newLine();
                bw.write(bdate1);
                bw.newLine();
                bw.write(bdate2);
                bw.newLine();
                bw.write(bdate3);
                bw.newLine();
                bw.write(password);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
        }
    }

    public void readFromGuestFile() throws FileNotFoundException {
        Scanner output = new Scanner(System.in);

        output = new Scanner(file2);
        while (output.hasNextLine()) {
            Guest temp = new Guest();
            String firstname = output.nextLine();
            String lastname = output.nextLine();
            String username = output.nextLine();
            String bdate1=output.nextLine();
            String bdate2=output.nextLine();
            String bdate3=output.nextLine();
            String password=output.nextLine();
            
            temp.addFirstname(firstname);
            temp.addlastname(lastname);
            temp.addUsername(username);           
            temp.addBdate1(bdate1);
            temp.addBdate2(bdate2);
            temp.addBdate3(bdate3);
            temp.addPassword(password);
            
            addGuestList(temp);
        }
        output.close();

    }

    public void writeToReservationFile() throws FileNotFoundException {
        int sMonth;
        int sDay;
        int sYear;

        int eMonth;
        int eDay;
        int eYear;

        int roomType;
        int roomNum;

        int guestId;

        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < guestList.size(); i++) {
                sMonth = reservationList.get(i).getStartMonth();
                sDay = reservationList.get(i).getStartDay();
                sYear = reservationList.get(i).getStartYear();

                eMonth = reservationList.get(i).getEndMonth();
                eDay = reservationList.get(i).getEndDay();
                eYear = reservationList.get(i).getEndYear();

                roomType = reservationList.get(i).getRoomType();
                roomNum = reservationList.get(i).getRoomNumber();

                guestId = reservationList.get(i).getGuestId();

                if (!file.exists()) {
                    file.createNewFile();
                }

                bw.write(sMonth);
                bw.newLine();
                bw.write(sDay);
                bw.newLine();
                bw.write(sYear);
                bw.newLine();
                bw.write(eMonth);
                bw.newLine();
                bw.write(eDay);
                bw.newLine();
                bw.write(eYear);
                bw.newLine();
                bw.write(roomType);
                bw.newLine();
                bw.write(roomNum);
                bw.newLine();
                bw.write(guestId);
                bw.newLine();

            }
            bw.close();
        } catch (IOException e) {
        }
    }

    public void readFromReservationFile() throws FileNotFoundException {
        Scanner output = new Scanner(System.in);

        output = new Scanner(file);
        while (output.hasNextLine()) {
            ReservationModel temp = new ReservationModel();
            int sMonth = output.nextInt();
            int sDay = output.nextInt();
            int sYear = output.nextInt();

            int eMonth = output.nextInt();
            int eDay = output.nextInt();
            int eYear = output.nextInt();

            int roomType = output.nextInt();
            int roomNum = output.nextInt();
            int guestId = output.nextInt();

            String startDate = sMonth + "/" + sDay + "/" + sYear;
            String endDate = eMonth + "/" + eDay + "/" + eYear;

            temp.addStartDate(startDate);
            temp.addEndDate(endDate);
            temp.addRoomType(roomType);
            temp.addRoomNumber(roomNum);
            temp.addGuestId(guestId);
            addReservationToDatabase(temp);
        }
        output.close();

    }
}
