/**
 * The simple receipt for the print receipt.
 *
 * @author SJK
 * @version 1.0
 */
public class SimpleReceipt implements PrintReceipt {

    private Model model;

    /**
     * Construct the simple receipt.
     */
    public SimpleReceipt() {

    }

    /**
     * Add the model to the receipt.
     *
     * @param m the model
     */
    public void addModel(Model m) {
        model = m;
    }

    /**
     * Set the receipt to a string.
     *
     * @return the string receipt
     */
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
        temp = temp + " " + "\n";
        for (int i = 0; i < model.getTempReserveList().size(); i++) {

            price = price + model.getTempReserveList().get(i).getRoomType();
            temp = temp + "Room number: " + model.getTempReserveList().get(i).getRoomNumber() + "\n";
        }
        temp = temp + " " + "\n";
        temp = temp + "Total Price: " + price + "\n";
        return temp;
    }

}
