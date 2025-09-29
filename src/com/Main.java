 
package com;
 
public class Main {
    public static void main(String[] args) {
        CustomerCollection customerCollection = new CustomerCollection();
        new ShopMainForm(customerCollection).setVisible(true);
    }
 
}
