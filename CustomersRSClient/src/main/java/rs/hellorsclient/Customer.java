/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.hellorsclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + '}';
    }

    public Customer() {
    }

    public void setName(String name) {
        this.name = name;
    }
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
}
