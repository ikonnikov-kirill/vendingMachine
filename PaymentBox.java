/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingMachine;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author workway
 */
public class PaymentBox {

    private Scanner scanner = new Scanner(System.in);
    private Controller blankController;

    public PaymentBox() {
        System.out.println("Payment Box created");
        
    }

    public void Connector (Controller oneController){
        blankController = oneController;
    }
    
    public void Pay(String a, VendingMachine vendingMachine) {
        int c = 0;
        HashMap<Integer, Integer> moneyBoxChange = new HashMap<>();
        //String ab = new String();
        while (true) {
         //   ab=vendingMachine.getProduct(a);
            System.out.println(" you selected " + a
                    + ", please pay " + vendingMachine.getPrice(a) + "$");
            System.out.println("Please pay by notes $1, $5, $10, $20, $50, $100");
            int b = scanner.nextInt();

            if (b != 1 & b != 5 & b != 10 & b != 20 & b != 50 & b != 100) {
                System.out.println("there is no note " + b + "$");
            }

            if (b == 1 | b == 5 | b == 10 | b == 20 | b == 50 | b == 100) {
                //temp hashmap to hold notes
                if (moneyBoxChange.containsKey(b) == true) {
                    moneyBoxChange.replace(b, moneyBoxChange.get(b) + 1);
                } else {
                    moneyBoxChange.put(b, 1);
                }

                if (b < vendingMachine.getPrice(a)) {
                    System.out.println("you paid " + b + "$");
                    c = c + b;

                    //if sum less than price
                    if (c < vendingMachine.getPrice(a)) {
                        int d = vendingMachine.getPrice(a) - c;
                        System.out.println("you paid total " + c + "$ you still missing " + d + "$");
                    }
                    // if sum is more than price 
                    if (c >= vendingMachine.getPrice(a)) {
                        int d = c - vendingMachine.getPrice(a);
                        System.out.println("you paid total " + c + "$ you owed change " + d + "$");
                        c = 0;
                        blankController.productPaid(a, d, moneyBoxChange);
                    }
                }

                if (b >= vendingMachine.getPrice(a)) {
                    System.out.println("you paid " + b + "$");
                    c = c + b;
                    int d = c - vendingMachine.getPrice(a);
                    System.out.println("you paid total " + c + "$ you owed change " + d + "$");
                    c = 0;
                    blankController.productPaid(a, d, moneyBoxChange);
                    return;
                }
            }
        }  // ||
    }
}
