/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custejb.view;

import custejb.business.Facade;
import java.util.Optional;
import java.util.logging.Logger;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Model
public class Login {

    @Inject
    Facade facade;

    @NotNull(message = "{emptyuser}")
    @Size(min = 4, message = "{shortuser}")
    private String newUser;

    /**
     * @return the user
     */
    public String getNewUser() {
        return newUser;
    }
    private static final Logger LOG = Logger.getLogger(Login.class.getName());

    /**
     * @param user the user to set
     */
    public void setNewUser(String user) {
        this.newUser = user;
    }

    public String login() {
        facade.login(newUser);
        return "index?faces-redirect=true";
    }

    public boolean isLogged() {
        return getLoggedUser().isPresent();
    }
    
    public Optional<String> getLoggedUser() {
        return facade.loggedUser();
    }
    
    public String logout() {
        facade.logout();
        LOG.info("");
        return "index?faces-redirect=true";
    }

}
