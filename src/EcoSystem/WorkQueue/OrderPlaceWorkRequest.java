/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.WorkQueue;

import EcoSystem.Order.Order;
import EcoSystem.Order.OrderItem;

/**
 *
 * @author Lucy Bai
 */
public class OrderPlaceWorkRequest extends WorkRequest {
    
    private Order order;
    private int orderId;
    private OrderItem orderItem;
    
    public OrderPlaceWorkRequest(){
        order =new Order();
    }

    public Order getOrder() {
        return order;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
}
