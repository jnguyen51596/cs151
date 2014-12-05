import java.util.ArrayList;

/**
 * Guest class constructs the guest object with the required information and
 * implements method that retrieve his/her information 
 * @author John
 */
public class Guest {

    private String firstname;
    private String lastname;
    private String username;
    private String[] bdate = new String[3];
   
    private String password;
    private ArrayList<ReservationModel> reservation;

    /**
     * Constructs the guest object by initializing an ArrayList of ReservationModels
     */
    public Guest() {
        reservation = new ArrayList<ReservationModel>();
    }

    /**
     * Constructs the guest object with the information provided
     * @param fname a string - guest first name
     * @param lname a string - guest last name
     * @param uname a string - guest username
     * @param date a string - guest birthdate 
     * @param psw a string - guest password
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
     * Set guest's first name
     * @param firstname a string with guest's first name
     */
    public void addFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Set guest's last name
     * @param lastname a string with the guest's last name
     */
    public void addlastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Set guest's username 
     * @param username a String with the guest's username
     */
    public void addUsername(String username) {
        this.username = username;
    }

    /**
     * Set guest's password
     * @param password 
     */
    public void addPassword(String password) {
        this.password = password;
    }

    /**
     * Set guest birthdate month
     * @param bdate1 
     */
    public void addBdate1(String bdate1) {
        this.bdate[0] = bdate1;
    }

    /**
     * Set guest birthdate month
     * @param bdate2 
     */
    public void addBdate2(String bdate2) {
        this.bdate[1] = bdate2;
    }

    /**
     * Set guest birthdate year
     * @param bdate3 
     */
    public void addBdate3(String bdate3) {
        this.bdate[2] = bdate3;
    }

    /**
     * Retrieve guest's username
     * @return username, guest's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieve guest's password
     * @return password, guest's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieve guest's first name
     * @return firstname, the guest's first name
     */
    public String getFirstName() {
        return firstname;
    }

    /**
     * Retrieve guest's last name
     * @return lastname, the guest's last name
     */
    public String getLastName() {
        return lastname;
    }

    /**
     * Retrieve guest birthdate month
     * @return bdate[0] the guest birthdate month
     */
    public String getBdate1() {
        return bdate[0];
    }

    /**
     * Retrieve guest birthdate day
     * @return bdate[1] the guest birthdate day
     */
    public String getBdate2() {
        return bdate[1];

    }

    /**
     * Retrieve guest birthdate year
     * @return bdate[2] the guest birthdate year
     */
    public String getBdate3() {
        return bdate[2];
    }

    /**
     * Add a new reservation to the guest
     * @param r reservationmodel object with the reservation information
     */
    public void addReservation(ReservationModel r) {
        reservation.add(r);
    }

    /**
     * Gives a list of all data from the reservations
     * @return allReservation, a string with the information of all reservations from a guest
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
