/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.integration;

import custcdi.model.Cust;
import custcdi.model.Order;
import java.util.List;

public interface CustDAO {

    void addOrder(int custId, int price);

    void add(String name);

    void delete(int id);

    List<Cust> all();

    public List<Order> allOrders();
    

    public Cust find(int id);

}
