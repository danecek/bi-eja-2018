/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.controller;

import custcdi.business.Facade;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@LoginQ
public class LoginAction implements CustAction {

    @Inject
    public LoginAction(Facade facade, HttpServletRequest r) {
        this.facade = facade;
        this.r = r;
    }
    
    Facade facade;
    HttpServletRequest r;

    @Override
    public void execute() {
        facade.login(r.getParameter("user"));
    }
    
}
