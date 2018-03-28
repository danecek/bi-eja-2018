/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.business;

import java.io.Serializable;
import java.util.Optional;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

@SessionScoped
@Stateful
public class User implements Serializable {

    private String user;

    public void login(String user) {
        this.user = user;

    }

    public void logout() {
        this.user = null;

    }

    public Optional<String> user() {
        return Optional.ofNullable(user);
    }

}
