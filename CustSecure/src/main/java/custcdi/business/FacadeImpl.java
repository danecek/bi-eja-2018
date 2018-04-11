/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.business;

import custcdi.integration.CustDAO;
import custcdi.model.Cust;
import custcdi.model.Order;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Stateless
//@FacadeLogger
@DeclareRoles({"cadmin"})
@PermitAll // wildfly bug ?
public class FacadeImpl implements Facade {

    @Inject
    CustDAO custDAO;
    @Inject
    HttpServletRequest req;

//    @Inject
//    public FacadeImpl(CustDAO custDAO, Login login) {
//        this.custDAO = custDAO;
//        this.login = login;
//    }
    @Override
    @RolesAllowed({"cadmin"})
    public void addCust(String name) {
        custDAO.add(name);

    }

    @Override
    public List<Cust> allCusts() {
        return custDAO.all();
    }

    @Override
    public boolean login(String username, String passw) {
        try {
            req.login(username, passw);
            return true;
        } catch (ServletException ex) {
            return false;
        }
    }

    @Override
    public void logout() {
        try {
            req.logout();
        } catch (ServletException ex) {
            Logger.getLogger(FacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Optional<String> user() {
        Principal p = req.getUserPrincipal();
        if (p != null) {
            return Optional.of(p.getName());
        } else {
            return Optional.empty();
        }
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

    @Override
    public void updateCust(int custId,  String name) {
        custDAO.update(custId, name);
    }

}
