/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.persist;

import custcdi.model.Customer;
import java.util.List;


public interface CustDAO {

    List<Customer> all();

    void createCust(String name);
    
}
