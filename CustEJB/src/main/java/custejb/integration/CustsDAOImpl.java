/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custejb.integration;

import custejb.model.Cust;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Singleton
@ApplicationScoped
public class CustsDAOImpl implements CustDAO {

    @Inject
    private KeyGen kg;

    private Map<Integer, Cust> data;

    @Override
    public void add(String name) {
        Cust c = new Cust(kg.newKey(), name);
        data.put(c.getId(), c);
    }

    @Override
    @Lock(LockType.READ)
    public List<Cust> all() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void delete(int id) {
        data.remove(id);
    }

    @Override
    @Lock(LockType.READ)
    public Cust find(int id) {
        return data.get(id);
    }

    @PostConstruct
    void init() {
        data = new HashMap<>();
        add("Tom");

    }

}
