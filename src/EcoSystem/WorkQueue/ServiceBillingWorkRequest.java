/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.WorkQueue;

import EcoSystem.Service.Service;

/**
 *
 * @author UmairAkhtar
 */
public class ServiceBillingWorkRequest extends WorkRequest{
    private Service service;
    private Double payment;
    public ServiceBillingWorkRequest(){
        service =new Service();
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    
}
