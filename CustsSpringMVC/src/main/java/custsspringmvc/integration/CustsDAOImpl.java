/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvc.integration;

import custsspringmvc.integration.KeyGen;
import custsspringmvc.model.Cust;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

public class CustsDAOImpl implements CustsDAO {

    private final KeyGen kg;

    public CustsDAOImpl(KeyGen kg) {
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
        add("Bob");

    }

}
