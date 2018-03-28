/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custejb.business;

import custejb.integration.CustDAO;
import custejb.model.Cust;
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

    public FacadeImpl() {
    }
//
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
    public Optional<String> loggedUser() {
        return user.getUser();
    }

    @Override
    public void delCust(int id) {
        custDAO.delete(id);
    }

    @Override
    public Cust findCust(int id) {
        return custDAO.find(id);
    }

}
