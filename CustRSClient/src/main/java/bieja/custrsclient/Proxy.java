/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bieja.custrsclient;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Proxy {

    public static final Proxy inst = new Proxy();
    private final WebTarget cs;

    private Proxy() {
        Client c = ClientBuilder.newClient();
        cs = c.target("http://localhost:8081/CustomersRS/customersApp/customers");

    }

    List<Customer> getAll() {
        Response r = cs.request().accept(MediaType.APPLICATION_XML).get();
        return r.readEntity(new GenericType<List<Customer>>() {
        });
    }

}
