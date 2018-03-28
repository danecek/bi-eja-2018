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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
@FacadeLogger
public class FacadeImpl implements Facade {

    private static final Logger LOG = Logger.getLogger(FacadeImpl.class.getName());
    @Inject
    CustDAO custDAO;
    // @Inject
    User user;

    private User getUser() {
        try {
            if (user == null) {
                user = (User) new InitialContext().lookup("java:module/User");
                LOG.info(user.toString());
            }
            return user;
        } catch (NamingException ex) {
            Logger.getLogger(FacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

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
        this.getUser().login(user);
    }

    @Override
    public void logout() {
        user.logout();
    }

    @Override
    public Optional<String> loggedUser() {
        return getUser().getUser();
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
