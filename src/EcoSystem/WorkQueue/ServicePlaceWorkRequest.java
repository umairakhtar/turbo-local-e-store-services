/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.WorkQueue;

import EcoSystem.Employee.Employee;
import EcoSystem.Service.Service;


/**
 *
 * @author Lucy Bai
 */
public class ServicePlaceWorkRequest extends WorkRequest{
    private Service service;
    private Employee employee;
    private int equipmentQty;
    public ServicePlaceWorkRequest(){
        service=new Service();
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getEquipmentQty() {
        return equipmentQty;
    }

    public void setEquipmentQty(int equipmentQty) {
        this.equipmentQty = equipmentQty;
    }
    
    
}
