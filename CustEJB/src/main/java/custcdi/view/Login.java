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

    private String user;

    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    public String login() {
        facade.login(user);
        return "index?faces-redirect=true";
    }

}
