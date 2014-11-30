

import java.util.ArrayList;

/**
 *
 * @author Kelly
 */
public class GuestList {
    
    ArrayList<Guest> guestList = new ArrayList<>();

    
    private class Guest{
        
        String firstname;
        String lastname;
        String username;
        String[] bdate = new String[3];;
        String password; 
        
        public Guest(String fname, String lname, String uname, String date, String psw){
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
        
    }
    
    public void addGuest(String fname, String lname, String uname, String date, String psw){
        guestList.add(new Guest(fname, lname, uname, date, psw));
    }
    
    
    public String getName(String user){
        for (Guest guestList1 : guestList) {
            if (guestList1.username.equals(user)) {
                return guestList1.lastname + ", " + guestList1.firstname;
            }
        }
        
        return "Not found";
    }
    
    
    public String getBirthdate(String user){
        for (Guest guestList1 : guestList) {
            if (guestList1.username.equals(user)) {
                return guestList1.bdate[0] + "-" + guestList1.bdate[1] + "-" + guestList1.bdate[2];
            }
        }        
        
        return "Not found";
    }
    
    public int authenticate(String user, String psw){
        for (Guest guestList1 : guestList) {
            if (guestList1.username.equals(user)) {
                if(guestList1.password.equals(psw)){
                    return 1;
                }
                else
                    return 0;
                    
            }
        }
        
        return -1;
    }
    
    
}
