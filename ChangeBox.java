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
public class ChangeBox {
    
    
    public ChangeBox () {
        System.out.println("Change Box created");
    }
    
    public void dispenseChange (HashMap <Integer, Integer> notes) {
        for (Integer key : notes.keySet()) {
            System.out.println("change dispersed note $"+key+", quantity "+notes.get(key));
        }
    }
}
