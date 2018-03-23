/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.business;

import custcdi.integration.CustDAO;
import custcdi.model.Cust;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Size;

@RequestScoped
@FacadeLogger
public class FacadeImpl implements Facade {

    CustDAO custDAO;
    Login login;

    @Inject
    public FacadeImpl(CustDAO custDAO, Login login) {
        this.custDAO = custDAO;
        this.login = login;
    }

    @Override
    public void addCust(String name) {
        custDAO.add(name);

    }

    @Override
    public List<Cust> allCusts() {
        return custDAO.all();
    }

    @Override
    public void login(@Size(min = 3) String user) {
        login.login(user);
    }

    @Override
    public void logout() {
        login.logout();
    }

    @Override
    public Optional<String> user() {
        return login.user();
    }

}
