/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Customer;

import EcoSystem.AccountValidator.Validator;
import EcoSystem.Order.OrderList;

/**
 *
 * @author abhinnankit
 */
public class Customer {
    
    private String name;
    private int customerId;
    private String address;
    private String email;
    private OrderList orderList;
    public Customer() {
        this.customerId = Validator.randValue();
        this.orderList = new OrderList();
        
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderList orderList) {
        this.orderList = orderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
