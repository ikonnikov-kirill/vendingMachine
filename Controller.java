/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingMachine;
import java.util.HashMap;
/**
 *
 * @author workway
 */
public class Controller {
    private VendingMachine blankVendingMachine;
    private PaymentBox blankPaymentBox;
    private ChangeBox blankChangeBox;
    private Dispensary blankDispensary;
    
    public Controller (VendingMachine oneVendingMachine, PaymentBox onePaymentBox,
            ChangeBox oneChangeBox, Dispensary oneDispensary) {
        blankVendingMachine = oneVendingMachine;
        blankPaymentBox=onePaymentBox;
        blankChangeBox=oneChangeBox;
        blankDispensary=oneDispensary;
        System.out.println("Controller created");    
    }
    
    public void productSelected (String a, VendingMachine vendingMachine) {
        blankPaymentBox.Pay(a, vendingMachine);
      }
    
    public void productPaid (String ab, int c, HashMap<Integer,Integer> notes) {
     blankVendingMachine.dispenseProduct(ab);
     blankDispensary.dispenseProduct(ab);
     blankVendingMachine.changeCash(c, notes);
    }
}
