import java.util.ArrayList;

/**
 * The guest
 *
 * @author John
 * @version 1.0
 */
public class Guest {

    private String firstname;
    private String lastname;
    private String username;
    private String[] bdate = new String[3];
    ;
    private String password;

    private ArrayList<ReservationModel> reservation;

    public Guest() {
        reservation = new ArrayList<ReservationModel>();

    }

    public Guest(String fname, String lname, String uname, String date, String psw) {
        String delims = "/";
        String[] bd = date.split(delims);

        firstname = fname;
        lastname = lname;
        username = uname;
        bdate[0] = bd[0];
        bdate[1] = bd[1];
        bdate[2] = bd[2];
        password = psw;
    }

    public void addFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void addlastname(String lastname) {
        this.lastname = lastname;
    }

    public void addUsername(String username) {
        this.username = username;
    }

    public void addPassword(String password) {
        this.password = password;
    }

    public void addBdate1(String bdate1) {
        this.bdate[0] = bdate1;
    }

    public void addBdate2(String bdate2) {
        this.bdate[1] = bdate2;
    }

    public void addBdate3(String bdate3) {
        this.bdate[2] = bdate3;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getBdate1() {
        return bdate[0];
    }

    public String getBdate2() {
        return bdate[1];

    }

    public String getBdate3() {
        return bdate[2];
    }

    public void addReservation(ReservationModel r) {
        reservation.add(r);
    }

    public String getAllReservation() {
        String allReservation = null;
        String startDate;
        String endDate;
        for (int i = 0; i < reservation.size(); i++) {
            startDate = reservation.get(i).getStartMonth() + "/" + reservation.get(i).getStartDay() + "/" + reservation.get(i).getStartYear();
            endDate = reservation.get(i).getEndMonth() + "/" + reservation.get(i).getEndDay() + "/" + reservation.get(i).getEndYear();
            allReservation = allReservation + reservation.get(i).getRoomType() + " " + reservation.get(i).getRoomNumber() + " " + startDate + " " + endDate + "\n";
        }
        return allReservation;
    }
}
