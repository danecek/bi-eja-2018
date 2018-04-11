/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.view;

import custcdi.business.Facade;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Login {

    @Inject
    Facade facade;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    /**
     * @param username the user to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String login() {
        facade.login(username, password);
        return "index?faces-redirect=true";
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
