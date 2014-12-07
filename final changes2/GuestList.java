import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The guest list with all users.
 *
 * @author SJK
 * @version 1.0
 */
public class GuestList {

    ArrayList<Guest> guestList = new ArrayList<>();

    /**
     * Construct the guest list.
     */
    public GuestList() {

    }

    /**
     * Add Guest to guest list.
     *
     * @param fname the first name
     * @param lname the last name
     * @param uname the username
     * @param date the birthdate
     * @param psw the password
     * @param m the model
     * @throws FileNotFoundException
     */
    public void addGuest(String fname, String lname, String uname, String date, String psw, Model m) throws FileNotFoundException {
        Guest temp = new Guest(fname, lname, uname, date, psw);
        guestList.add(temp);
        m.getDatabase().addToGuestList(temp);
        m.getDatabase().writeToGuestFile();
    }

    /**
     * Add guest to database.
     *
     * @param g the guest
     */
    public void addFromDatabase(Guest g) {
        guestList.add(g);
    }

    /**
     * Get the user full name.
     *
     * @param user the user
     * @return the full name
     */
    public String getName(String user) {
        for (Guest guestList1 : guestList) {
            if (guestList1.getUsername().equals(user)) {
                return guestList1.getLastName() + ", " + guestList1.getFirstName();
            }
        }

        return "Not found";
    }

    /**
     * Get the birthdate.
     *
     * @param user the user
     * @return the birth date
     */
    public String getBirthdate(String user) {
        for (Guest guestList1 : guestList) {
            if (guestList1.getUsername().equals(user)) {
                return guestList1.getBdate1() + "-" + guestList1.getBdate2() + "-" + guestList1.getBdate3();
            }
        }

        return "Not found";
    }

    /**
     * Authenticate the user to login.
     *
     * @param user the username
     * @param psw the password
     * @return
     */
    public int authenticate(String user, String psw) {
        for (Guest guestList1 : guestList) {
            if (guestList1.getUsername().equals(user)) {
                if (guestList1.getPassword().equals(psw)) {
                    return 1;
                } else {
                    return 0;
                }

            }
        }

        return -1;
    }

}
