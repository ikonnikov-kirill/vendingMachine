/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingMachine;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author workway
 */
public class VendingMachine {

    private Display oneDisplay;
    private ChangeBox oneChangeBox;
    private Dispensary oneDispensary;
    private Controller oneController;
    private PaymentBox onePaymentBox;
    private HashMap< Integer, Integer> moneyBox = new HashMap<>();
    private HashMap<String, Integer> productBox = new HashMap<>();
    //integer massive 0 denomination, 1 product price
    private Integer[][] setupBox = {{1, 5, 10, 20, 50, 100}, {7, 1, 4, 1, 5, 2}};
    // string massive - 0 product names
    private String[] products = {"chocolate", "cola", "biscuit", "gum", "pie", "chips"};
    // random generator for qty banknotes and products
    private Random batch = new Random();

    public VendingMachine() {
        System.out.println("Vending Machine created");
        oneDisplay = new Display(this);
        oneChangeBox = new ChangeBox();
        oneDispensary = new Dispensary();
        onePaymentBox = new PaymentBox();
        oneController = new Controller(this, onePaymentBox, oneChangeBox, oneDispensary);
        onePaymentBox.Connector(oneController);
        refill();
        oneDisplay.choice(oneController);
    }

    public Integer getSize() {
        return productBox.size();
    }
    
    public void refillTest (){
        for (Integer key:productBox.values()){
            if (key==0) {
                refill();
            }
        }
        for (Integer key:moneyBox.values()){
            if (key==0) {
                refill();
            }
        }
        
    }
  

    public Integer getPrice(String i) {
        int j=0;
        for (int k=0; k<products.length; k++){
            if (i.equals(products[k])){
                j=k;
                break;
            }
        }
        return setupBox[1][j];
    }
    
      public void menu () {
       
          for (String key:productBox.keySet()){
            System.out.print("product "+key);
            System.out.println(" price $"+getPrice(key));         
            
 }}

    public String getProduct(int i) {
        return products[i];
    }
    
    
    public String getProductName (String b) {
        String temp=null;
        for (String key:productBox.keySet()){
            if (b.equals(key)){
                temp=key;
            }            
       }
        return temp;
    }

    public void dispenseProduct(String a) {
        for(String key:productBox.keySet()){
            if (key==a){
            productBox.replace(a, productBox.get(a) - 1);    
            }
        }
    }

    public void changeCash(int c, HashMap<Integer, Integer> notes) {
        for (Integer key : notes.keySet()) {
            for (Integer key2 : moneyBox.keySet()) {
                if (key == key2) {
                    moneyBox.replace(key2, moneyBox.get(key2) + notes.get(key));
                    notes.remove(key);
                }
            }
        }
        //2 get cahnge c
        while (c > 0) {
             for (Integer key : moneyBox.keySet()) {
                if (c >= key) {
                    moneyBox.replace(key, moneyBox.get(key) - 1);
                    c = c - key;
                    if (notes.containsKey(key) == true){
                    notes.replace(key, notes.get(key) + 1);
                    } else {
                    notes.put(key, 1);
                    }
                    
                    }
                }
            }
        
        if (c==0){
             
                    oneChangeBox.dispenseChange(notes);
         }
        
    }

    public void refill() {
        //qty of products
        //same nu of products or differnt nu of products?
        int x = batch.nextInt(60 - 30) + 30;
        for (int i = 0; i < x; i++) {
            int y = batch.nextInt(6 - 0) + 0;
            int z = setupBox[0][y];

            if (moneyBox.containsKey(z) == true) {
                moneyBox.replace(z, moneyBox.get(z) + 1);
            } else {
                moneyBox.put(z, 1);
            }
        }
        //printout
        // x new banknotes

        for (Integer key : moneyBox.keySet()) {
            System.out.println("banknote " + key + " quantity " + moneyBox.get(key));
        }

        //qty of products
        x = batch.nextInt(50 - 25) + 25;
        for (int i = 0; i < x; i++) {
            int y = batch.nextInt(6 - 0) + 0;
            String z = products[y];
            if (productBox.containsKey(z) == true) {
                productBox.replace(z, productBox.get(z) + 1);
            } else {
                productBox.put(z, 1);
            }
        }
        //printout
        // x nu new products
        //print out of summary
        for (String key : productBox.keySet()) {
            System.out.println("product " + key + " quantity " + productBox.get(key));
        }
    }
}
