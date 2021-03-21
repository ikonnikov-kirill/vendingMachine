/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingMachine;

import java.util.Scanner;

/**
 *
 * @author workway
 */
public class Display {
    private VendingMachine blankVendingMachine;
    private Controller blankController;
    Scanner scanner = new Scanner(System.in);
    
  public Display (VendingMachine onVendingMachine) {
      blankVendingMachine=onVendingMachine;
        System.out.println("Display created");
    }
    public void choice (Controller controller) {
        blankController=controller;
        
        while (true) {    
            
             //refill test
           blankVendingMachine.refillTest();
           
            System.out.println("");
            System.out.println("Vending Machine Menu");
            
            // shoudl be string 
            blankVendingMachine.menu();
             System.out.println(" type product you want");
            System.out.println("For exit press type - exit");
            //int a = scanner.nextInt();
            String a = scanner.next();
            
            if (a.equals("exit")) {
            System.out.println("you are leaving Vending Machine, bye bye!!!");
            System.exit(0);
            }
            
           if (a.equals(blankVendingMachine.getProductName(a))) {
               System.out.println(blankVendingMachine.getProductName(a));
               blankController.productSelected(a, blankVendingMachine);
           } else {
               System.out.println("non existent product, try again");
                continue;
           }
          
           
           
        }
    }        
}            
         