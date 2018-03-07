/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danecek
 */
public class Customers {

    public static final Customers inst = new Customers();

    List<Customer> customers = new ArrayList<>();

    private Customers() {
        customers.add(new Customer("Tom"));
    }

    public Customer getFirst() {
        return customers.get(0);
    }

    public List<Customer> getAll() {
        return customers;
    }

}
