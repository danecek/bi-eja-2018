/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers;

import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("customers")
public class CustomersResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Customer> getXml() {
        return Customers.inst.getAll();
    }

}
