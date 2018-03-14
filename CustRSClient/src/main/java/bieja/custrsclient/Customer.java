/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bieja.custrsclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + '}';
    }
    
    
    
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
