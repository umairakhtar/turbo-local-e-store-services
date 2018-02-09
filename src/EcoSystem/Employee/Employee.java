/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Employee;

import EcoSystem.AccountValidator.Validator;

/**
 *
 * @author abhinnankit
 */
public class Employee {
    
    private String name;
    private int id;

    public Employee() {
        id = Validator.randValue();
    }
    
    public enum SkillType{
        Plumbing("Plumbing"),
        Handyman("Handyman"),
        Cleaning("Cleaning"), 
        Electrical("Electrical");
        
        private String value;
        private SkillType(String value){
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
