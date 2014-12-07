import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The database that read and write files to store into model.
 *
 * @author SJk
 * @version 1.0
 */
public class Database {

    ArrayList<Guest> guestList = new ArrayList<Guest>();
    ArrayList<ReservationModel> reservationList = new ArrayList<ReservationModel>();
    File file = new File("reservation.txt");
    File file2 = new File("guest.txt");
    File file3 = new File("printReceipt.txt");

    /**
     * Construct the database.
     */
    public Database() {

    }

    /**
     * Add Guest to database guest list.
     *
     * @param g the guest
     */
    public void addToGuestList(Guest g) {
        guestList.add(g);
    }

    /**
     * Add reservation to the database reservation list.
     *
     * @param r the reservation
     */
    public void addReservationToDatabase(ReservationModel r) {
        reservationList.add(r);
    }

    /**
     * Get the GuestList.
     *
     * @return the guest List
     */
    public ArrayList<Guest> getGuestListFromDatabase() {
        return guestList;
    }

    /**
     * Get the reservation list.
     *
     * @return the reservation list
     */
    public ArrayList<ReservationModel> getReservationListFromDatabase() {
        return reservationList;
    }

    /**
     * Write to the guest file.
     *
     * @throws FileNotFoundException
     */
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

    /**
     * Read from the guest file.
     *
     * @throws FileNotFoundException
     */
    public void readFromGuestFile() throws FileNotFoundException {
        Scanner output = new Scanner(System.in);

        output = new Scanner(file2);
        while (output.hasNextLine()) {

            Guest temp = new Guest();
            String firstname = output.nextLine();
            String lastname = output.nextLine();
            String username = output.nextLine();
            String bdate1 = output.nextLine();
            String bdate2 = output.nextLine();
            String bdate3 = output.nextLine();
            String password = output.nextLine();

            temp.addFirstname(firstname);
            temp.addlastname(lastname);
            temp.addUsername(username);
            temp.addBdate1(bdate1);
            temp.addBdate2(bdate2);
            temp.addBdate3(bdate3);
            temp.addPassword(password);

            addToGuestList(temp);

        }
        output.close();

    }

    /**
     * Write to the reservation file.
     *
     * @throws FileNotFoundException
     */
    public void writeToReservationFile() throws FileNotFoundException {
        String sMonth;
        String sDay;
        String sYear;

        String eMonth;
        String eDay;
        String eYear;

        String roomType;
        String roomNum;

        String guestId;

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
            for (int i = 0; i < reservationList.size(); i++) {
                sMonth = Integer.toString(reservationList.get(i).getStartMonth());
                sDay = Integer.toString(reservationList.get(i).getStartDay());
                sYear = Integer.toString(reservationList.get(i).getStartYear());

                eMonth = Integer.toString(reservationList.get(i).getEndMonth());
                eDay = Integer.toString(reservationList.get(i).getEndDay());
                eYear = Integer.toString(reservationList.get(i).getEndYear());

                roomType = Integer.toString(reservationList.get(i).getRoomType());
                roomNum = Integer.toString(reservationList.get(i).getRoomNumber());

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

    /**
     * Read from the reservation file.
     *
     * @throws FileNotFoundException
     */
    public void readFromReservationFile() throws FileNotFoundException {
        Scanner output = new Scanner(System.in);

        output = new Scanner(file);
        while (output.hasNextLine()) {

            ReservationModel temp = new ReservationModel();
            int sMonth = Integer.parseInt(output.nextLine());
            int sDay = Integer.parseInt(output.nextLine());
            int sYear = Integer.parseInt(output.nextLine());

            int eMonth = Integer.parseInt(output.nextLine());
            int eDay = Integer.parseInt(output.nextLine());
            int eYear = Integer.parseInt(output.nextLine());

            int roomType = Integer.parseInt(output.nextLine());
            int roomNum = Integer.parseInt(output.nextLine());

            String guestId = output.nextLine();

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

    /**
     * Write to the receipt file.
     *
     * @param r the string of receipt
     * @throws FileNotFoundException
     */
    public void writeToReceiptFile(String r) throws FileNotFoundException {

        try {
            FileWriter fw = new FileWriter(file3);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(file3);
            BufferedWriter bw = new BufferedWriter(fw);

            if (!file3.exists()) {
                file3.createNewFile();
            }
            bw.write(r);
            bw.close();
        } catch (IOException e) {
        }
    }
}
