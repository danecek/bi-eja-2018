/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.integration;

import custcdi.model.Cust;
import java.util.List;


public interface CustDAO {

    void add(String name);
    
    void delete(int id);

    List<Cust> all();

    public Cust find(int id);
    
}
