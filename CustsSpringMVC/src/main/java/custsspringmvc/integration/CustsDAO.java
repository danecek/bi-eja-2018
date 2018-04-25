/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvc.integration;


import custsspringmvc.model.Cust;
import java.util.List;


public interface CustsDAO {

    void add(String name);

    List<Cust> all();
    
}
