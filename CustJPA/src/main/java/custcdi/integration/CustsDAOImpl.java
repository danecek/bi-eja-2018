/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.integration;

import custcdi.model.Cust;
import custcdi.model.Order;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CustsDAOImpl implements CustDAO {
    
    @PersistenceContext
    EntityManager em;


    @Override
    public void add(String name) {
        em.persist(new Cust(name));
    }

    @Override
    public List<Cust> all() {
        TypedQuery<Cust> q = em.createNamedQuery("allCusts", Cust.class);
        return q.getResultList();
    }
    
    @Override
    public List<Order> allOrders() {
        TypedQuery<Order> q = em.createNamedQuery("allOrders", Order.class);
        return q.getResultList();
    }

    @Override
    public void delete(int id) {
        em.remove(find(id));
    }

    @Override
    public Cust find(int id) {
        return em.find(Cust.class, id);
    }

    @Override
    public void addOrder(int custId, int price) {
        Cust c = find(custId);
        em.persist(new Order(price, c));
    }

}
