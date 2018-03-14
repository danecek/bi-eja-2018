/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.integration;

import custcdi.model.Cust;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@ApplicationScoped
@Alternative
@Specializes
@Priority(Interceptor.Priority.APPLICATION)
public class CustsDAOMock extends CustDAOImpl {

    private final KeyGen kg;

    @Inject
    public CustsDAOMock(KeyGen kg) {
        this.kg = kg;
    }

    private Map<Integer, Cust> data;

    @Override
    public void add(String name) {
        Cust c = new Cust(kg.newKey(), name);
        data.put(c.getId(), c);
    }

    @Override
    public List<Cust> all() {
        return new ArrayList<>(data.values());
    }
    
    @PostConstruct    
    void init() {
        data = new HashMap<>();
        add("Tom");
        
    }

}
