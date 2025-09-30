package com;

import javax.swing.table.DefaultTableModel;

public class CustomerCollection {

    private Customer[] customerArray = new Customer[0];
    private static final int UNITE_PRICE = 500;

    private void extendArray() {
        Customer[] tempArray = new Customer[customerArray.length + 1];
        for (int i = 0; i < customerArray.length; i++) {
            tempArray[i] = customerArray[i];
        }
        customerArray = tempArray;
    }

    public boolean addCustomer(Customer customer) {
        boolean isAdded;
        extendArray();
        customerArray[customerArray.length - 1] = customer;
        if (!customerArray[customerArray.length - 1].equals("null")) {
            return isAdded = true;
        }
        return isAdded = false;

    }

    public String generateOrderId() {
        if (customerArray.length == 0) {
            return "B0001";
        }
        String ls = customerArray[customerArray.length - 1].getOrderID();
        int lsNo = Integer.parseInt(ls.substring(1));
        return String.format("B%04d", lsNo + 1);
    }

    public void sortCustomerArray() {
        for (int i = 0; i < customerArray.length - 1; i++) {
            for (int j = 0; j < customerArray.length - 1; j++) {
                if (customerArray[j].getQty() < customerArray[j + 1].getQty()) {
                    Customer tempOrId = customerArray[j];
                    customerArray[j] = customerArray[j + 1];
                    customerArray[j + 1] = tempOrId;
                }
            }
        }
    }

    public DefaultTableModel loadTable() {
        String[] columns = {"Order ID", "Customer Name", "Total"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Customer c : customerArray) {
            Object[] row = {c.getOrderID(), c.getCustomerID(), c.getQty() * UNITE_PRICE};
            model.addRow(row);
        }

        return model;
    }

    public DefaultTableModel loadCustomerTable(Customer[] customer) {
        for (int i = 0; i < customer.length; i++) {   
                String[] columns = {"Order ID", "order Qty", "Total"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);

                for (Customer c : customerArray) {
                    Object[] row = {c.getOrderID(), c.getQty(), c.getQty() * UNITE_PRICE};
                    model.addRow(row);
                }

                return model;
            
        }
             return null;
    }

    public Customer[] searchCustomer(String id) {
        Customer[] tempArray = new Customer[customerArray.length];
        for (int i = 0;i<customerArray.length;i++) {
            if (customerArray[i].getOrderID().equalsIgnoreCase(id)) {
                 tempArray[i]=customerArray[i];
            }
        }
        
        return tempArray;
    }

}
