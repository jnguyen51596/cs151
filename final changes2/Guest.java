import java.util.ArrayList;

/**
 * The guest with user information.
 *
 * @author SJK
 * @version 1.0
 */
public class Guest {

    private String firstname;
    private String lastname;
    private String username;
    private String[] bdate = new String[3];
    private String password;

    private ArrayList<ReservationModel> reservation;

    /**
     * Construct the guest.
     */
    public Guest() {
        reservation = new ArrayList<ReservationModel>();

    }

    /**
     * Construct guest based on parameters.
     *
     * @param fname the first name
     * @param lname the last name
     * @param uname the user name
     * @param date the birth date
     * @param psw the password
     */
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

    /**
     * Add the first name to object.
     *
     * @param firstname the first name
     */
    public void addFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Add last name to object.
     *
     * @param lastname the last name
     */
    public void addlastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Add user name to object.
     *
     * @param username the username
     */
    public void addUsername(String username) {
        this.username = username;
    }

    /**
     * Add password to the object.
     *
     * @param password the password
     */
    public void addPassword(String password) {
        this.password = password;
    }

    /**
     * Add birth month.
     *
     * @param bdate1 the month
     */
    public void addBdate1(String bdate1) {
        this.bdate[0] = bdate1;
    }

    /**
     * Add birth day.
     *
     * @param bdate2 the day
     */
    public void addBdate2(String bdate2) {
        this.bdate[1] = bdate2;
    }

    /**
     * Add the birth year.
     *
     * @param bdate3 the year.
     */
    public void addBdate3(String bdate3) {
        this.bdate[2] = bdate3;
    }

    /**
     * Get the user name.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstname;
    }

    /**
     * Get the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastname;
    }

    /**
     * Get the birth month.
     *
     * @return the month
     */
    public String getBdate1() {
        return bdate[0];
    }

    /**
     * Get the birth day.
     *
     * @return the day
     */
    public String getBdate2() {
        return bdate[1];

    }

    /**
     * Get the birth year.
     *
     * @return the birth year.
     */
    public String getBdate3() {
        return bdate[2];
    }

    /**
     * Add reservation to guest.
     *
     * @param r the reservation model
     */
    public void addReservation(ReservationModel r) {
        reservation.add(r);
    }

    /**
     * Get all reservation on guest.
     *
     * @return the string
     */
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
