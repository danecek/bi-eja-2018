/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.business;

import custcdi.integration.CustDAO;
import custcdi.model.Cust;
import custcdi.model.Order;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@FacadeLogger
public class FacadeImpl implements Facade {

    @Inject
    CustDAO custDAO;
    @Inject
    User user;

//    @Inject
//    public FacadeImpl(CustDAO custDAO, Login login) {
//        this.custDAO = custDAO;
//        this.login = login;
//    }
    @Override
    public void addCust(String name) {
        custDAO.add(name);

    }

    @Override
    public List<Cust> allCusts() {
        return custDAO.all();
    }

    @Override
    public void login(String user) {
        this.user.login(user);
    }

    @Override
    public void logout() {
        user.logout();
    }

    @Override
    public Optional<String> user() {
        return user.user();
    }

    @Override
    public void delCust(int id) {
        custDAO.delete(id);
    }

    @Override
    public Cust findCust(int id) {
        return custDAO.find(id);
    }

    @Override
    public void addOrder(int custId, int price) {
        custDAO.addOrder(custId, price);
    }

    @Override
    public List<Order> allOrders() {
        return custDAO.allOrders();
    }

}
