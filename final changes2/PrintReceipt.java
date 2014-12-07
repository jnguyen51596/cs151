/**
 * The interface of print receipt.
 *
 * @author SJK
 * @version 1.0
 */
public interface PrintReceipt {

    /**
     * Add the model.
     * 
     * @param m the model
     */
    public void addModel(Model m);

    /**
     * Set the receipt as a string.
     * 
     * @return the string receipt
     */
    public String setReceiptToString();

}
