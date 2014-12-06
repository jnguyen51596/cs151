/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author John
 */
public class SimpleReceipt implements PrintReceipt {

    private Model model;

    public SimpleReceipt() {

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
            
            price = price + model.getTempReserveList().get(i).getRoomType();
            temp = temp + "Room number: " + model.getTempReserveList().get(i).getRoomNumber() + "\n";
        }
        temp = temp +" "+ "\n";
        temp = temp + "Total Price: " + price + "\n";
        return temp;
    }

}
