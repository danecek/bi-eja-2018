/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.persist;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import custcdi.model.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@ApplicationScoped
@Alternative
@Priority(Interceptor.Priority.APPLICATION)
public class CustDAOMock implements CustDAO {

    @Inject
    KeyGen kg;

    public CustDAOMock() {
    }

    Map<Integer, Customer> data = new HashMap<>();

    @Override
    public void createCust(String name) {
        Customer c = new Customer(kg.key(), name);
        data.put(c.getId(), c);
    }

    @Override
    public List<Customer> all() {
        return new ArrayList<>(data.values());
    }

}
