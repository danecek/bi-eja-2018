/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.hellorsclient;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author danecek
 */
public class Proxy {

    public static Proxy instance = new Proxy();
    private final WebTarget contextRoot;
    WebTarget customersTarget;
    public static final MediaType MT = MediaType.TEXT_XML_TYPE;

    private Proxy() {
        Client client = ClientBuilder.newBuilder().newClient();
        contextRoot = client.target("http://localhost:8080/HelloRS/");
        contextRoot.register(new CustClientRequestFilter());
        customersTarget = contextRoot.path("customers");//.queryParam("a", "avalue")
    }

    public List<Customer> get() {
        List<Customer> customers = customersTarget.
                request().
                accept(MT).
                get(new GenericType<List<Customer>>() {
                });
        return customers;
    }

    void addCustomer(Customer customer) {
        Response r = customersTarget.
                request().accept(MT).
                put(Entity.entity(customer, MT));
        System.out.println(r);

    }
}
