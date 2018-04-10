/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p;

import java.security.Principal;
import java.util.Date;
import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Model
public class LoginBB {

    @Inject
    private HttpServletRequest httpRequest;

    public Principal getPrinciple() {
        return httpRequest.getUserPrincipal();
    }

    @Inject
    JMSContext co;
    @Resource(lookup = "java:/jms/queue/ExpiryQueue")
    Queue q;

    public void send() {
        co.createProducer().send(q, new Date().toString());
    }

    public String login() {
        try {
            httpRequest.login("student", "student");
            return "index?facec-redirect=true";
        } catch (ServletException ex) {
            return "loginfailed";
        }
    }

}
