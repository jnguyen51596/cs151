import java.util.ArrayList;

/**
 * GuestList class contructs an arraylist of guests and contains methods that 
 * interacts with the guest information and authenticates a guest user
 * @author Kelly
 */
public class GuestList {

    ArrayList<Guest> guestList = new ArrayList<>();

//    private class Guest{
//        
//        String firstname;
//        String lastname;
//        String username;
//        String[] bdate = new String[3];;
//        String password; 
//        
//        public Guest(String fname, String lname, String uname, String date, String psw){
//            String delims = "/";
//            String[] bd = date.split(delims);
//
//            firstname = fname;
//            lastname = lname;
//            username = uname;
//            bdate[0] = bd[0];
//            bdate[1] = bd[1];
//            bdate[2] = bd[2];
//            password = psw;
//        }
//        
//    }
    public GuestList() {
    }

    /**
     * Add a new guest to the guest list
     * @param fname a string with the guest first name
     * @param lname a string with the guest last name
     * @param uname a string with the guest username
     * @param date a string with the guest birthdate
     * @param psw  a string with the guest password
     */
    public void addGuest(String fname, String lname, String uname, String date, String psw) {
        guestList.add(new Guest(fname, lname, uname, date, psw));
    }
    
    /**
     * Add a guest to the database
     * @param g a guest object 
     */
    public void addFromDatabase(Guest g){
        guestList.add(g);
    }
    
    /**
     * Get the name from a guest according to the given username
     * @param user a string with the username
     * @return the Full name of the guest or 
     *         Not found, if the username is not in the guestlist
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
     * Retrieve the birthdate of a guest according to his/her username
     * @param user a string with the guest username
     * @return the birthdate of the guest or
     *         Not found if the username does not match any on the guest list
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
     * Verifies that username matches the password
     * @param user a string, the guest's username
     * @param psw a string, the guest's password
     * @return 1 if the password matches the stored user password
     *         0 if the password did not match
     *        -1 if the user does not exists
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
