/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.WorkQueue;

import EcoSystem.Order.Order;

/**
 *
 * @author Lucy Bai
 */
public class ProductBillingWorkRequest extends WorkRequest{
    
    private Order order;
    private Double payment;
    public ProductBillingWorkRequest(){
        order =new Order();
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
}
