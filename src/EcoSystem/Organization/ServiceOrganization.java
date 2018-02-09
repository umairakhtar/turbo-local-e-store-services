/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Organization;

import EcoSystem.Role.Role;
import EcoSystem.Role.ServiceManRole;
import EcoSystem.Role.ServiceRole;
import EcoSystem.ServicePrice.ServicePriceCatalog;
import java.util.ArrayList;

/**
 *
 * @author abhinnankit
 */
public class ServiceOrganization extends Organization{
    private ServicePriceCatalog servicePrices;
    public ServiceOrganization() {
        super(Organization.Type.Service.getValue());
        this.servicePrices=new ServicePriceCatalog();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ServiceRole());
        roles.add(new ServiceManRole());
        return roles;
    }

    public ServicePriceCatalog getServicePrices() {
        return servicePrices;
    }

    public void setServicePrices(ServicePriceCatalog servicePrices) {
        this.servicePrices = servicePrices;
    }
    
}
