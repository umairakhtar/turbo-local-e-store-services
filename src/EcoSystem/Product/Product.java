/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Product;

import EcoSystem.AccountValidator.Validator;

/**
 *
 * @author Lucy Bai
 */
public class Product {
    private String name;
    private int quatity;
    private double price;
    private int productId;
    private String desc;
    
    public Product(){
        this.productId = Validator.randValue();
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
     
    @Override
    public String toString() {
        return name;
    }
    
}
