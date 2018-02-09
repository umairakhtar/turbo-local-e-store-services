/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.ServicePrice;

/**
 *
 * @author Lucy Bai
 */
public class ServicePrice {
    private String type;
    private Double price;
    private Double equipmentPrice;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getEquipmentPrice() {
        return equipmentPrice;
    }

    public void setEquipmentPrice(Double equipmentPrice) {
        this.equipmentPrice = equipmentPrice;
    }
    @Override
    public String toString() {
        return type;
    }
}
