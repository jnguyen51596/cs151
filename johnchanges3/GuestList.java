import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
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

    public void addGuest(String fname, String lname, String uname, String date, String psw, Model m) throws FileNotFoundException {
        Guest temp=new Guest(fname, lname, uname, date, psw);
        guestList.add(temp);
        m.getDatabase().addToGuestList(temp);
        m.getDatabase().writeToGuestFile();
    }
    public void addFromDatabase(Guest g)
    {
        guestList.add(g);
    }
    
    public String getName(String user) {
        for (Guest guestList1 : guestList) {
            if (guestList1.getUsername().equals(user)) {
                return guestList1.getLastName() + ", " + guestList1.getFirstName();
            }
        }

        return "Not found";
    }

    public String getBirthdate(String user) {
        for (Guest guestList1 : guestList) {
            if (guestList1.getUsername().equals(user)) {
                return guestList1.getBdate1() + "-" + guestList1.getBdate2() + "-" + guestList1.getBdate3();
            }
        }

        return "Not found";
    }

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
