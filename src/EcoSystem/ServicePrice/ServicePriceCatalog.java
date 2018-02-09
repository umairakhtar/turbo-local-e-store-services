/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.ServicePrice;

import EcoSystem.DeliveryPrice.DeliveryPrice;
import java.util.ArrayList;

/**
 *
 * @author Lucy Bai
 */
public class ServicePriceCatalog {
   private ArrayList<ServicePrice> servicePrices;
   public ServicePriceCatalog(){
       servicePrices =new ArrayList();
   }

    public ArrayList<ServicePrice> getServicePrices() {
        return servicePrices;
    }

    public void setServicePrices(ArrayList<ServicePrice> servicePrices) {
        this.servicePrices = servicePrices;
    }
    
    public ServicePrice addServicePrice(){
        ServicePrice dp = new ServicePrice();
        servicePrices.add(dp);
        return dp;
    }
    
    public void deleteProduct(ServicePrice del){
        servicePrices.remove(del);
    }
    
    
}
