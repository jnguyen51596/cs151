/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author John
 */
public class ComprehensiveReceipt implements PrintReceipt {

    private Model model;

    public ComprehensiveReceipt() {

    }

    public void addModel(Model m) {
        model = m;
    }

    public String setReceiptToString() {
        int price = 0;
        String temp = "";
        temp = temp + "User Id: " + model.getCurrentUsername() + "\n";
        for (int i = 0; i < model.getDatabase().getGuestListFromDatabase().size(); i++) {
            Guest tempGuest = model.getDatabase().getGuestListFromDatabase().get(i);
            if (model.getCurrentUsername().equals(tempGuest.getUsername())) {
                temp = temp + "Full Name: " + tempGuest.getFirstName() + " " + tempGuest.getLastName() + "\n";
                break;
            }
        }
        temp = temp +" "+ "\n";
        for (int i = 0; i < model.getTempReserveList().size(); i++) {
            ReservationModel tempRe = model.getTempReserveList().get(i);
            price = price + tempRe.getRoomType();
            temp = temp + "Room number: " + tempRe.getRoomNumber() + "\n";
            temp = temp + "Room Type: $" + tempRe.getRoomType() + "\n";
            temp = temp + "Start Date: " + tempRe.getStartMonth() + "/" + tempRe.getStartDay() + "/" + tempRe.getStartYear() + "\n";
            temp = temp + "End Date: " + tempRe.getEndMonth() + "/" + tempRe.getEndDay() + "/" + tempRe.getEndYear() + "\n";
            temp = temp +" "+ "\n";
       
        }
        temp = temp + "Total Price: $" + price + "\n";
        
        return temp;
    }
    

}
