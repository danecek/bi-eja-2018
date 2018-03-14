/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.business;

import custcdi.model.Customer;
import custcdi.persist.CustDAO;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class Facade {

    @Inject
    CustDAO custDAO;

    @Inject
    Login login;

    public Optional<String> user() {
        return login.user();
    }

    public Iterable<Customer> all() {
        return custDAO.all();
    }

    public void add(String item) {
        custDAO.createCust(item);
     }

    public void login(String user) {
        login.login(user);
    }

}
